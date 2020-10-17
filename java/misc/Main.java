import java.util.ArrayList;
import java.util.HashSet;

public class Main {


    static String remove(String s1, String s2){
        HashSet<Character> H = new HashSet<>();
        for(char c : s2.toCharArray()){
            H.add(c);
        }
        StringBuffer sb = new StringBuffer();
        for(char c : s1.toCharArray()){
            if(!H.contains(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        ArrayList<Character> L = new ArrayList<>();
        L.add('a');
        L.add('b');
        Character[] A =  new Character[2];
        L.toArray(A);
        System.out.println(new String(String.valueOf(A)));
    }

    public static void test(){
        System.out.println("Hello from SPACEMACS"); 
    }
}
