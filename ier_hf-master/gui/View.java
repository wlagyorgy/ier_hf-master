package gui;

import jason.asSyntax.Literal;
import jason.environment.Environment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;


public class View extends JFrame {
    JPanel leftpnl;
    JPanel rightpnl;
    JButton logbtn;



    JButton bicepsbtn;
    JLabel bicepslb;
    JButton tricepsbtn;
    JLabel tricepslb;
    JButton chestbtn;
    JLabel chestlb;
    JButton backbtn;
    JLabel  backlb;
    JButton shoulderbtn;
    JLabel shoulderlb;
    JButton absbtn;
    JLabel abslb;
    JButton legbtn;
    JLabel leglb;

    JTextField idtf;
    JLabel idlb;


    public View(Environment env, int free) {
        initComponents();
        environment = env;
        places = new int[free];
    }

    public void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //we need this
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        inituphalf();
        initdownhalf();
        add(uphalf);
        add(downhalf);
        pack();
        setVisible(true);
    }

    /*
    private class CarinbtnActLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (carplatetf.getText().length() > 0) {
                environment.addPercept(Literal.parseLiteral("car_in"));
            }
        }
    }

*/

    private class LoginActLis implements ActionListener{
        public void actionPermormed(ActionEvent e)
        {
            if (logbtn.getText()=="Belépés"){
                if (idtf.Text)
            }
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
/*
    private class EmergencyActLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            environment.addPercept(Literal.parseLiteral("emergency"));
        }
    }

  */

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


    //a panel bal oldalának inicializálása
    private void initleftpnl() {

        //a belépési panel inicializálás, elemek inicializálása
        leftpnl=new JPanel();
        idlb=new JLabel("Adja meg a kártyaszámát!");
        logbtn=new JButton("Belépés");
        idtf=new JTextField();

        logbtn.addActionListener(new LoginActLis() );

       //elemek hozzáadása a panelhez
        leftpnl.setLayout(new BoxLayout());
        leftpnl.add(idlb);
        leftpnl.add(idtf);
        leftpnl.add(logbtn);


    }

    private void inituphalf() {
        uphalf = new JPanel();
        carinbtn = new JButton("Auto be");
        caroutbtn = new JButton("Auto ki");
        carplatel = new JLabel("Rendszam:");
        carplatetf = new JTextField();
        carplatetf.setColumns(10);
        freespacel = new JLabel("Szabad helyek szama: ");
        textfreespacel = new JLabel();
        textfreespacel.setText("     ");

        carinbtn.addActionListener(new CarinbtnActLis());
        caroutbtn.addActionListener(new CaroutbtnActLis());

        uphalf.setLayout(new FlowLayout());
        uphalf.add(carinbtn);
        uphalf.add(caroutbtn);
        uphalf.add(carplatel);
        uphalf.add(carplatetf);
        uphalf.add(freespacel);
        uphalf.add(textfreespacel);
    }
}
