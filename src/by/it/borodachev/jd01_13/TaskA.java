package by.it.borodachev.jd01_13;

import java.util.HashMap;

@SuppressWarnings("all")
public class TaskA {
    public static void main(String[] args) {
        try {
        if (Math.random()>0.5)
            new HashMap<String, String>(null);
        else
            Integer.parseInt("привет");
        }
        catch (NullPointerException | NumberFormatException e){
            Helper.printEx(e);
        }
    }



}
