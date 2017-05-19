import gui.User;
import gui.View;
import jason.asSyntax.*;

import jason.environment.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.logging.*;
import javax.swing.*;

public class mainEnv extends Environment {
    private Logger logger = Logger.getLogger("ier_hf.mas2j." + mainEnv.class.getName());
    View display = new View(this);
    int WeirdthingPlace;
    ArrayList<User> users = new ArrayList<>();
    User activeUser=null;
    @Override
    public void init(String[] args) {
        super.init(args);
        Random rnd = new Random();
        String[] firstnames = {"Karcsi", "Lajos", "Peter", "Andras", "Marcell", "Zsolt", "Kata", "Gyorgy", "Krisztina", "Istvan"};
        String[] lastnames = {"Kovacs", "Varga", "Nemeth", "Toth", "Olah", "Lakatos", "Humbak", "Gyongyosi", "Amzug", "Papp"};
        for (int i=0;i<10;i++){
            String name = firstnames[i] + lastnames[i];
            int id = rnd.nextInt()%10000;
            //maxsúlyok
            int bicepsmax = rnd.nextInt()%60 + 20;
            int tricepsmax = rnd.nextInt()%40 + 20;
            int chestmax = rnd.nextInt()%80 + 40;
            int backmax = rnd.nextInt()%140 + 60;
            int shouldermax = rnd.nextInt()%50 + 40;
            int absmax = rnd.nextInt()%20 + 10;
            int legmax = rnd.nextInt()%120 + 40;
            
       
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
            serialweight.put("Biceps", Math.abs(bicepsmax - rnd.nextInt()%20));
            serialweight.put("Triceps", Math.abs(tricepsmax - rnd.nextInt()%20));
            serialweight.put("Chest", Math.abs(chestmax - rnd.nextInt()%40));
            serialweight.put("Back", Math.abs(backmax - rnd.nextInt()%60));
            serialweight.put("Shoulder", Math.abs(shouldermax - rnd.nextInt()%40));
            serialweight.put("Abs", Math.abs(absmax - rnd.nextInt()%10));
            serialweight.put("Leg", Math.abs(legmax - rnd.nextInt()%40));
           
            //eltöltött idő
            HashMap<String, Double> stationtimes=new HashMap<>();
            stationtimes.put("Biceps", 1.0*bicepsmax * rnd.nextInt()%10000/100);
            stationtimes.put("Triceps", tricepsmax * 1.5 *rnd.nextInt()%10000/100);
            stationtimes.put("Chest", chestmax * 0.76 * rnd.nextInt()%10000/100);
            stationtimes.put("Back", backmax * 0.4 * rnd.nextInt()%10000/100);
            stationtimes.put("Shoulder", 1.0*shouldermax * rnd.nextInt()%10000/100);
            stationtimes.put("Abs", 1.0*absmax * 3 * rnd.nextInt()%10000/100);
            stationtimes.put("Leg", legmax * 0.5 * rnd.nextInt()%10000/100);
            
            users.add(new User(name, id, maxweight, serialweight, stationtimes));     
        }
      //  display.SetFreespaces(free_spaces);
    }



    @Override
    public boolean executeAction(String agName, Structure action) {

        if (action.getFunctor().equals("decision")) {

            for (User user : users){
                if (user.getId()==display.getIDText()){
                    activeUser=user;
                }
            }
            if (activeUser==null) {
                addPercept(Literal.parseLiteral("denied"));
            }
            else
            {
                addPercept(Literal.parseLiteral("let_in"));
            }

        } else if (action.getFunctor().equals("let_out")) {
            addPercept(Literal.parseLiteral("delete_car"));

        } else if (action.getFunctor().equals("let_in_asap")) {
            addPercept(Literal.parseLiteral("accident"));

        } else if (action.getFunctor().equals("open_gates")) {
            logger.info("Free to move for the emergency");
            clearAllPercepts();

        } else if (action.getFunctor().equals("get_car_info")) {
            logger.info("Problem at " + String.valueOf(display.getWeirdthingplace()));
            addPercept(Literal.parseLiteral("ask_info"));

        } else if (action.getFunctor().equals("send_info")) {
            logger.info("Send car info");
            display.getCarbyplace(display.getWeirdthingplace());
            addPercept(Literal.parseLiteral("info"));

        } else if (action.getFunctor().equals("send_alarm")) {
            Hashtable<String, String> problem = display.getCarinfo();
            logger.info("Notify: " + problem.get("name") + " Call: " + problem.get("number") + " Send email: " +
            problem.get("email") + " For: " + problem.get("thing"));
            clearAllPercepts();

        } else if (action.getFunctor().equals("add_new_car")) {
            if (free_spaces > 0) {
                free_spaces--;
                display.AddActualCarplate();
                display.SetFreespaces(free_spaces);
                logger.info("Car added");
            } else {
                logger.info("No more free space");
            }
            clearAllPercepts();

        } else if (action.getFunctor().equals("free_car")) {
            if (display.isValidCarplateInput()) {
                free_spaces++;
                logger.info("Valid car plate");
                display.RemoveCarplate();
                display.SetFreespaces(free_spaces);
            } else {
                logger.info("Invalid car plate");
            }
            clearAllPercepts();

        } else if (action.getFunctor().equals("notify_all_flood")) {
            logger.info("Notify all");
            for (int i = 0; i < display.sizeofcars(); i++) {
                logger.info("Send email to: " + display.getcaremail(i) + " and send SMS to: " + display.getcarnumber(i));
            }
            clearAllPercepts();

        } else if (action.getFunctor().equals("notify_all_fire")) {
            logger.info("Notify all");
            for (int i = 0; i < display.sizeofcars(); i++) {
                logger.info("Send email to: " + display.getcaremail(i) + " and send SMS to: " + display.getcarnumber(i));
            }
            clearAllPercepts();

        } else {
            logger.info("executing: " + action + ", but not implemented!");
            return false;
        }
        return true;
    }
*/
    @Override
    public void stop() {
        super.stop();
    }
}


