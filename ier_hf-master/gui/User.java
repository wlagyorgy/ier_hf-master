package gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class User{
    String name;
    int id;
    HashMap<String,Integer> maxweight;
    HashMap<String, Integer> serialweight;
    HashMap<String, Double> stationtimes;

    public User(String name, int id, HashMap<String,Integer> maxweight,HashMap<String, Integer> serialweight,
                HashMap<String, Double> stationtimes){
        this.name = name;
        this.id = id;
        this.maxweight = maxweight;
        this.serialweight = serialweight;
        this.stationtimes = stationtimes;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public HashMap<String, Integer> getMaxweight() {
        return maxweight;
    }

    public void setMaxweight(String key, int max) {maxweight.put(key, max);}

    public HashMap<String, Integer> getSerialweight() {
        return serialweight;
    }

    public void setSerialweight(String key, int serial) {
        serialweight.put(key, serial);
    }

    public HashMap<String, Double> getStationtimes() {
        return stationtimes;
    }

    public void setStationtimes(String key, double time) {
        double min = stationtimes.get(key);
        stationtimes.put(key, min+time);
    }
}
