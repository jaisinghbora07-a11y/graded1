
public class Practice2{

    // Using inbuilt methods

    public static String Reverse(String S){
        StringBuilder res=new StringBuilder(S);
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        String e="Jai Singh Bora";
        System.err.println(Reverse(e));
    }
}