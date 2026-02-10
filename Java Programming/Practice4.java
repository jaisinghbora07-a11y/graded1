import java.util.*;

public class Practice4{
    public static void main(String[]args){
        HashMap<String,Integer> h=new HashMap<>();
        h.put("Jai", 5);
        h.put("Gaurav", 6);
        h.put("Ararstu", 3);
        h.put("Ayush", 4);
        int k=h.get("Jai");
        System.out.println(k);
        h.replace("Jai",9);
        System.out.println(h);
        h.remove("Ayush");
        System.out.println(h);
        }
    }
