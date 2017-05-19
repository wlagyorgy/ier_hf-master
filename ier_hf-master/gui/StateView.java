package gui;

import jason.asSyntax.Literal;
import jason.environment.Environment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.*;
import java.lang.Integer;


public class StateView extends JFrame {
    JPanel leftpnl;
    JLabel statisticslb;
    JLabel statisticsta;


    JPanel rightpnl;
    JLabel weightlb;
    JTextField weighttf;
    JButton pushbtn;
    JLabel counterlb;
    JLabel traininglb;

    JButton leavebtn;

    User activeUser;
    public String trainingType;
    int counter;
    int actualWeight;
    Environment env;
    HashMap<Integer,Integer> weights;
    long tStart;
    long tStop;
    double eTime;


    public StateView(Environment env, String type, User activeUser) {
        this.env = env;
        trainingType = type;
        counter = 0;
        this.activeUser=activeUser;
        initComponents();

    }

    public void initComponents() {
        //elindul a timer

        tStart=System.currentTimeMillis();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //we need this
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        leftpnl = new JPanel();
        traininglb = new JLabel(trainingType);
        statisticslb = new JLabel("Statistics");
        String stats="<html> Machine type: "+trainingType.toString()+"<br>Name: "+activeUser.getName()+"<br> ID:"+
                String.valueOf(activeUser.getId())+"<br> Max weight: "+activeUser.getMaxweight().get(trainingType).toString()+"<br> Serial weight: "
                +activeUser.getSerialweight().get(trainingType).toString()+"<br> Station time: "+ activeUser.getStationtimes().get(trainingType).toString()+"</html>";



        statisticsta = new JLabel(stats);




        leftpnl.setLayout(new BoxLayout(leftpnl, BoxLayout.Y_AXIS));
        leftpnl.add(statisticslb);
        leftpnl.add(statisticsta);

        add(leftpnl);

        rightpnl = new JPanel();
        weightlb = new JLabel("Weight:");
        weighttf = new JTextField("20");
        actualWeight = 20;
        pushbtn = new JButton("Push");
        pushbtn.addActionListener(new PushActionListener());
        counterlb = new JLabel("0");
        leavebtn = new JButton("Leave!");
        leavebtn.addActionListener(new LeaveActionListener());
        rightpnl.setLayout(new BoxLayout(rightpnl, BoxLayout.Y_AXIS));
        rightpnl.add(weightlb);
        rightpnl.add(weighttf);
        rightpnl.add(pushbtn);
        rightpnl.add(counterlb);
        rightpnl.add(leavebtn);
        weights= new HashMap<Integer, Integer>();

        add(rightpnl);
        pack();
        setVisible(true);
    }

    private class PushActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            try {
                Integer.parseInt(weighttf.getText().toString());
                if (actualWeight != Integer.parseInt(weighttf.getText().toString())) {
                    if ( counter!=0) weights.put(actualWeight, counter);
                    counter = 0;
                    actualWeight = Integer.parseInt(weighttf.getText().toString());
                }
                counter++;

                counterlb.setText(Integer.toString(counter));
            } catch(Exception ex) {
            }
        }
    }

    private class LeaveActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ( counter!=0) weights.put(actualWeight, counter);
            tStop=System.currentTimeMillis();
            long s=tStop-tStart;
            eTime =s/60000.0;
            env.addPercept(Literal.parseLiteral("leave_place"));

            

        }
    }
    public int getMaxWeight(){
        Integer max = 0;
        for(Integer key: weights.keySet()){
            if(max<key) max = key;

        }

        return max;
    }
    public int getSerialMaxWeight(){
        Integer maxSerial = 0;
        for(Map.Entry<Integer, Integer> entry : weights.entrySet()){
            if(maxSerial<entry.getKey() && entry.getValue()>=10) maxSerial = entry.getKey();
        }
        return maxSerial;
    }
    public double getTimeSpent(){
        return eTime;
    }

}