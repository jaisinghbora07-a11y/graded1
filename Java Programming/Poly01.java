
import java.lang.classfile.Superclass;

class Gaurav{
    int a=12;
    String name="Jai";
    static void s(){
        System.out.println("Hello");
    }
}

class Arastu extends Gaurav{
    static void s(){
        System.out.println("Go");
    }
}

public class Poly01{
    public static void main(String[] args) {
        Gaurav obj1=new Gaurav();
        Arastu obj2=new Arastu();

        obj1.s();
        Superclass.s();
    }
}

