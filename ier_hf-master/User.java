import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class User{
    String name;
    unsigned int id;
    double sumtime;
    HashMap<String,Integer> maxweight;
    HashMap<String, Integer> serialweight;
    HashMap<String, Double> stationtimes;

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

    public double getSumtime() {
        return sumtime;
    }

    public void setSumtime(double sumtime) {
        this.sumtime = sumtime;
    }

    public HashMap<String, Integer> getMaxweight() {
        return maxweight;
    }

    public void setMaxweight(HashMap<String, Integer> maxweight) {
        this.maxweight = maxweight;
    }

    public HashMap<String, Integer> getSerialweight() {
        return serialweight;
    }

    public void setSerialweight(HashMap<String, Integer> serialweight) {
        this.serialweight = serialweight;
    }

    public HashMap<String, Double> getStationtimes() {
        return stationtimes;
    }

    public void setStationtimes(HashMap<String, Double> stationtimes) {
        this.stationtimes = stationtimes;
    }
}