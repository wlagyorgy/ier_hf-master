package gui;

import jason.asSyntax.Literal;
import jason.environment.Environment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.lang.Integer;


public class StateView extends JFrame {
    JPanel leftpnl;
    JLabel statisticslb;
    JTextArea staticsticta;
    
    
    JPanel rightpnl;
    JLabel weightlb;
    JTextField weighttf;
    JButton pushbtn;
    JLabel counterlb;
    
    JButton leavebtn;

    User actualUser;
    String trainingType;
    int counter;
    int actualWeight;
    Environment env;
    
    public StateView(Environment env, String type) {
        initComponents();
        environment = env;
        trainingType = type;
        counter = 0;
    }

    public void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //we need this
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        leftpnl = new JPanel();
        statisticslb = new JLabel("Statistics");
        statisticsta = new TextArea(20,20);
        leftpnl.setLayout(new BoxLayout());
        leftpnl.add(statisticslb);
        leftpnl.add(statisticsta);
        
        add(leftpnl);
        
        rightpnl = new JPanel();
        weightlb = new JLabel("Weight:");
        weighttf = new TextField("20");
        actualWeight = 20;
        pushbtn = new JButton("Push");
        pushbtn.addActionListener(new PushActionListener());
        counterlb = new Label("0");
        leavebtn = new JButton("Leave!");
        leavebtn.addActionListener(new LeaveActionListener());
        rightpnl.setLayout(new BoxLayout());
        rightpnl.add(weightlb);
        rightpnl.add(weighttf);
        rightpnl.add(pushbtn);
        rightpnl.add(counterlb);
        rightpnl.add(leavebtn);
        
        add(rightpnl);
        pack();
        setVisible(true);
    }
    private class PushActionListener implements ActionListener{
        public void actionPermormed(ActionEvent e)
        {
            if (weighttf.getText().matches("^[0-9]")) return;
            if (actualWeight != (int) weighttf.getText()){
                //TODO: hozzáad egy tároló listához (map)  
                counter = 0;
                actualWeight = (int) weighttf.getText();
            }
            counter++;
            counterlb.setText(Integer.toString(counter));
        }
    }
     private class LeaveActionListener implements ActionListener{
        public void actionPermormed(ActionEvent e)
        {
            env.addPercept(Literal.parseLiteral("leave_place"));
        }
     }
    public int getWeirdthingplace() {
        return weirdthingplace;
    }

    public void getCarbyplace(int place){
        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getPlace() == place){
                problem = cars.get(i);
            }
        }
    }

    public Hashtable<String, String> getCarinfo(){
        Hashtable<String,String> result = new Hashtable<>();
        result.put("name", problem.getName());
        result.put("email", problem.getEmail());
        result.put("number", String.valueOf(problem.getNumber()));
        result.put("thing", weirdthing);
        return result;
    }

    public void AddActualCarplate() {
        AddCarplate(carplatetf.getText());
    }

    public void AddCarplate(String car) {
        Car temp = new Car(car);
        temp.setPlace(getfreespace());
        cars.add(temp);
        refreshplatelist();
    }

    private void refreshplatelist() {
        model = new DefaultComboBoxModel(carplatesgen().toArray(new String[]{}));
        carplatecb.setModel(model);
    }

    public boolean isValidCarplateInput() {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < cars.size(); i++) {
            temp.add(cars.get(i).getCarplate());
        }
        return temp.contains(carplatetf.getText());
    }

    public void RemoveCarplate() {
        String car = carplatetf.getText();
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < cars.size(); i++) {
            temp.add(cars.get(i).getCarplate());
        }
        int index = temp.indexOf(car);
        places[cars.get(index).getPlace()] = 0;
        cars.remove(index);
        refreshplatelist();
    }

    private ArrayList<String> carplatesgen() {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < cars.size(); i++) {
            temp.add(cars.get(i).stringify());
        }
        return temp;
    }

    private int getfreespace() {
        int i = 0;
        while (places[i] != 0) {
            i++;
        }
        places[i] = 1;
        return i;
    }

    public int sizeofcars(){
        return cars.size();
    }

    public String getcaremail(int index){
        Car temp = cars.get(index);
        String result = new String(temp.getEmail());
        return result;
    }

    public String getcarnumber(int index){
        Car temp = cars.get(index);
        String result = new String(String.valueOf(temp.getNumber()));
        return result;
    }

    public void SetFreespaces(int spaces) {
        textfreespacel.setText(String.valueOf(spaces));
    }
}
