import gui.User;
import gui.View;
import jason.asSyntax.*;

import jason.environment.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.*;

public class mainEnv extends Environment {
    private Logger logger = Logger.getLogger("ier_hf.mas2j." + mainEnv.class.getName());
    View display = new View(this);

    ArrayList<User> users = new ArrayList<>();
    User activeUser=null;
    @Override
    public void init(String[] args) {
        super.init(args);
        Random rnd = new Random();
        String[] firstnames = {"Karcsi", "Lajos", "Peter", "Andras", "Marcell", "Zsolt", "Kata", "Gyorgy", "Krisztina", "Istvan"};
        String[] lastnames = {"Kovacs", "Varga", "Nemeth", "Toth", "Olah", "Lakatos", "Humbak", "Gyongyosi", "Amzug", "Papp"};
        for (int i=0;i<10;i++){
            String name = firstnames[i]+ " " + lastnames[i];
            int id = 10000+i;
            //maxsúlyok
            int bicepsmax = Math.abs(rnd.nextInt()%60) + 20;
            int tricepsmax = Math.abs(rnd.nextInt()%40) + 20;
            int chestmax = Math.abs(rnd.nextInt()%80) + 40;
            int backmax = Math.abs(rnd.nextInt()%140) + 60;
            int shouldermax = Math.abs(rnd.nextInt()%50) + 40;
            int absmax = Math.abs(rnd.nextInt()%20) + 10;
            int legmax = Math.abs(rnd.nextInt()%120) + 40;
            
       
            HashMap<String,Integer> maxweight = new HashMap<>();
            maxweight.put("Biceps", bicepsmax);
            maxweight.put("Triceps", tricepsmax);
            maxweight.put("Chest", chestmax);
            maxweight.put("Back", backmax);
            maxweight.put("Shoulder", shouldermax);
            maxweight.put("Abs", absmax);
            maxweight.put("Leg", legmax);
            
            //szériasúlyok.
            HashMap<String, Integer> serialweight = new HashMap<>();
            serialweight.put("Biceps", Math.abs(bicepsmax - Math.abs(rnd.nextInt()%20)));
            serialweight.put("Triceps", Math.abs(tricepsmax - Math.abs(rnd.nextInt()%20)));
            serialweight.put("Chest", Math.abs(chestmax - Math.abs(rnd.nextInt()%40)));
            serialweight.put("Back", Math.abs(backmax - Math.abs(rnd.nextInt()%60)));
            serialweight.put("Shoulder", Math.abs(shouldermax - Math.abs(rnd.nextInt()%40)));
            serialweight.put("Abs", Math.abs(absmax - Math.abs(rnd.nextInt()%10)));
            serialweight.put("Leg", Math.abs(legmax - Math.abs(rnd.nextInt()%40)));
           
            //eltöltött idő
            HashMap<String, Double> stationtimes=new HashMap<>();
            stationtimes.put("Biceps", 10.0+Math.abs(rnd.nextInt()%10000/100.0));
            stationtimes.put("Triceps",10.0+ Math.abs(rnd.nextInt()%10000/100.0));
            stationtimes.put("Chest", 10.0+Math.abs(rnd.nextInt()%10000/100.0));
            stationtimes.put("Back", 10.0+Math.abs(rnd.nextInt()%10000/100.0));
            stationtimes.put("Shoulder",10.0+ Math.abs(rnd.nextInt()%10000/100.0));
            stationtimes.put("Abs", 10.0+Math.abs(rnd.nextInt()%10000/100.0));
            stationtimes.put("Leg",10.0+ Math.abs(rnd.nextInt()%10000/100.0));
            
            users.add(new User(name, id, maxweight, serialweight, stationtimes));     
        }
      //  display.SetFreespaces(free_spaces);
    }

    public void refresh(int max, int serial, double time, String trainingType){
        if (activeUser.getMaxweight().get(trainingType)<max) activeUser.setMaxweight(trainingType, max);
        if (activeUser.getSerialweight().get(trainingType)<serial) activeUser.setSerialweight(trainingType, serial);
        activeUser.setStationtimes(trainingType, time);
    }

    @Override
    public boolean executeAction(String agName, Structure action) {

        if (action.getFunctor().equals("decision")) {
            clearAllPercepts();
            for (User user : users) {
                if (user.getId() == display.getIDText()) {
                    activeUser = user;
                }
            }
            if (activeUser == null) {
                addPercept(Literal.parseLiteral("denied"));
            } else {
                display.addUser(activeUser);
                addPercept(Literal.parseLiteral("let_in"));

            }

        }
        else if(action.getFunctor().equals("show_buttons")){
            display.showRightPanel();
            clearAllPercepts();
        } else if(action.getFunctor().equals("set_default")) {
            display.hideRightPanel();
            clearAllPercepts();
        }else if (action.getFunctor().equals("refresh")){
            refresh(display.getMax(), display.getSerial(), display.getTime(), display.getTtype());
            display.closestateview();
            clearAllPercepts();
        }else if (action.getFunctor().equals("delete")){
            clearAllPercepts();
        }
        return true;
    }


        @Override
        public void stop(){
            super.stop();
        }

    }

