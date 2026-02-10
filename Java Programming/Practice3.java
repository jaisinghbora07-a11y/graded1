
import java.util.ArrayList;
import java.util.List;

public class Practice3 {

    public static List<String> SubString(String S){
        List<String> res=new ArrayList<String>();
        for(int i=0;i<S.length();i++){
            for(int j=i;j<S.length();j++){
                res.add(S.substring(i, j+1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
    
}
