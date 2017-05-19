package gui;

import jason.asSyntax.Literal;
import jason.environment.Environment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class View extends JFrame {
    //bejelentkezési panel
    JPanel leftpnl;
    //a sikeres bejelentkezés után látható panel
    JPanel rightpnl;
    JButton logbtn;
    User activeUser;

    Environment env;

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
    StateView sv;



    public View(Environment environment) {
        initComponents();
        env = environment;
       // places = new int[free];
    }

    public int getMax(){
        return sv.getMaxWeight();
    }

    public int getSerial(){
        return sv.getSerialMaxWeight();
    }
    public void closestateview(){
        sv.dispatchEvent(new WindowEvent(sv, WindowEvent.WINDOW_CLOSING));
    }

    public double getTime(){
        return sv.getTimeSpent();
    }

    public String getTtype() {
        return sv.trainingType;
    }
    public void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //we need this
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        initleftpnl();
        initrightpnl();
        add(leftpnl);
        add(rightpnl);
        pack();
        setVisible(true);
    }

    public void addUser(User user){
        this.activeUser=user;

    }
    public int getIDText(){
        return Integer.parseInt(idtf.getText().toString());
    }

    public void showRightPanel(){
        rightpnl.setVisible(true);
        setSize(new Dimension(600,600));
        logbtn.setText("Logout");
    }
    public void hideRightPanel(){
        rightpnl.setVisible(false);
        setSize(new Dimension(100,200));
        logbtn.setText("Login");
    }

    private class LoginActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            env.clearAllPercepts();
            if (logbtn.getText().toString().equals("Login")){
                try{
                    Integer.parseInt(idtf.getText().toString());
                    env.addPercept(Literal.parseLiteral("log_in"));

                }catch(Exception ex) {

                    env.addPercept(Literal.parseLiteral("wrong_id"));
                }
            }
            else
                env.addPercept(Literal.parseLiteral("log_out"));
        }
        }

    private class BicepsbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String name = "Biceps";
            sv= new StateView(env,name,activeUser);
            sv.setSize(600,300);

        }
    }


    private class TricepsbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String name = "Triceps";
            sv= new StateView(env,name,activeUser);
            sv.setSize(600,300);
        }
    }

    private class ChestbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String name = "Chest";
            sv= new StateView(env,name,activeUser);
            sv.setSize(600,300);
        }
    }

    private class BackbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String name = "Back";
            sv= new StateView(env,name,activeUser);
            sv.setSize(600,300);
        }
    }

    private class ShoulderbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String name = "Shoulder";
            sv= new StateView(env,name,activeUser);
            sv.setSize(600,300);
        }
    }

    private class AbsbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String name = "Abs";
            sv= new StateView(env,name,activeUser);
            sv.setSize(600,300);
        }
    }

    private class LegbtnActLis implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String name = "Leg";
            sv= new StateView(env,name,activeUser);
            sv.setSize(600,300);
        }
    }



    //a panel bal oldalának inicializálása
    private void initleftpnl() {

        //a belépési panel inicializálás, elemek inicializálása
        leftpnl=new JPanel();
        idlb=new JLabel("Type the cardID:");
        logbtn=new JButton("Login");
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
        bicepsbtn = new JButton("Take place!");
        bicepslb = new JLabel("Bicepsmachine");

        tricepsbtn = new JButton("Take place!");
        tricepslb = new JLabel("Tricepsmachine");

        chestbtn = new JButton("Take place!");
        chestlb = new JLabel("Chestmachine");

        backbtn = new JButton("Take place!");
        backlb = new JLabel("Backmachine");

        shoulderbtn = new JButton("Take place!");
        shoulderlb = new JLabel("Shouldermachine");

        absbtn = new JButton("Take place!");
        abslb = new JLabel("Absmachine");

        legbtn =  new JButton("Take place!");
        leglb = new JLabel("Legmachine");


        //actionlistenerek a gombokra

        bicepsbtn.addActionListener(new BicepsbtnActLis());
        tricepsbtn.addActionListener(new TricepsbtnActLis());
        chestbtn.addActionListener(new ChestbtnActLis());
        backbtn.addActionListener(new BackbtnActLis());
        shoulderbtn.addActionListener(new ShoulderbtnActLis());
        absbtn.addActionListener(new AbsbtnActLis());
        legbtn.addActionListener(new LegbtnActLis());






        rightpnl.setLayout(new BoxLayout(rightpnl, BoxLayout.Y_AXIS));
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
