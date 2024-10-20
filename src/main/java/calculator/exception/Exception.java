package calculator;

import java.util.ArrayList;

public class Exception {

    public static int IsPositiveNum(String s){
        try{
            if(s == ""){
                throw new NumberFormatException();
            }
            int num = Integer.parseInt(s);
            if(num < 0){
                throw new IllegalArgumentException();
            }
            return num;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static void IsArrayNotEmpty(ArrayList<Integer> array){
        if(array.size() == 0){
            throw new IllegalArgumentException();
        }
    }


}
