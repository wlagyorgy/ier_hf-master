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
    //bejelentkezési panel
    JPanel leftpnl;
    //a siekres bejelentkezés után látható panel
    JPanel rightpnl;
    JButton logbtn;

    Enviroment enviroment;

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

        initleftpnl();
        initrightpnl();
        add(leftpnl);
        add(rightpnl);
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
        public void actionPerformed(ActionEvent e)
        {

            }
        }

    private class BicepsbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

        }
    }


    private class TricepsbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    private class ChestbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    private class BackbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    private class ShoulderbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    private class AbsbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    private class LegbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

        }
    }




/*
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
/*
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
*/

    //a panel bal oldalának inicializálása
    private void initleftpnl() {

        //a belépési panel inicializálás, elemek inicializálása
        leftpnl=new JPanel();
        idlb=new JLabel("Adja meg a kártyaszámát!");
        logbtn=new JButton("Belépés");
        idtf=new JTextField();

        logbtn.addActionListener(new LoginActLis() );

       //elemek hozzáadása a panelhez
        leftpnl.setLayout(new BoxLayout(leftpnl,BoxLayout.PAGE_AXIS));
        leftpnl.add(idlb);
        leftpnl.add(idtf);
        leftpnl.add(logbtn);

        leftpnl.setVisible(true);

    }

    //bejelentkezés után megjelenő panel inicializálása
    private void initrightpnl() {

        rightpnl = new JPanel();
        //panelen lévő elemek inicializálása
        bicepsbtn = new JButton("Helyet foglalok!");
        bicepslb = new JLabel("Bicepszgép");

        tricepsbtn = new JButton("Helyet foglalok!");
        tricepslb = new JLabel("Tricepszgép");

        chestbtn = new JButton("Helyet foglalok!");
        chestlb = new JLabel("Mellgép");

        backbtn = new JButton("Helyet foglalok!");
        backlb = new JLabel("Hátazógép");

        shoulderbtn = new JButton("Helyet foglalok!");
        shoulderlb = new JLabel("Vállazógép");

        absbtn = new JButton("Helyet foglalok!");
        abslb = new JLabel("Hasazóép");

        legbtn =  new JButton("Helyet foglalok!");
        leglb = new JLabel("Lábazógép");


        //actionlistenerek a gombokra

        bicepsbtn.addActionListener(new BicepsbtnActLis());
        tricepsbtn.addActionListener(new TricepsbtnActLis());
        chestbtn.addActionListener(new ChestbtnActLis());
        backbtn.addActionListener(new BackbtnActLis());
        shoulderbtn.addActionListener(new ShoulderbtnActLis());
        absbtn.addActionListener(new AbsbtnActLis());
        legbtn.addActionListener(new LegbtnActLis());






        rightpnl.setLayout(new FlowLayout());
        //elemek hozzáadása a panelhez
        rightpnl.add(bicepslb);
        rightpnl.add(bicepsbtn);
        rightpnl.add(tricepslb);
        rightpnl.add(tricepsbtn);
        rightpnl.add(chestlb);
        rightpnl.add(chestbtn);
        rightpnl.add(backlb);
        rightpnl.add(backbtn);
        rightpnl.add(shoulderlb);
        rightpnl.add(shoulderbtn);
        rightpnl.add(abslb);
        rightpnl.add(absbtn);
        rightpnl.add(leglb);
        rightpnl.add(legbtn);
        rightpnl.setVisible(false);

    }





}
