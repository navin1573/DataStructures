import java.util.*;
public class BasicBit{
    public static void main(String[] args) {
        showBin(9); 
        System.out.println(isOdd(7));
        System.out.println(isOdd(8));
    }
    // == BINARY ==
    static void showBin(int n){
        System.out.println(n+" = "+ Integer.toBinaryString(n));
    }
    static boolean isOdd(int n){
        if((n&1)==1){
            return true;
        }
        return false;
    }
}
