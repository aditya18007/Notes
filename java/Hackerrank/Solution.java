import java.util.TreeMap;

public class Solution {

    // Complete the circularArrayRotation function below.
    public static void main(String[] args) {
        int k = 9;
        for(int i = 0 ; i < k; i++){
            if(i > ((k)/2)){
                System.out.println(Integer.valueOf(i-k));
            } else{
                System.out.println(i);
            }
        }
    }
}

