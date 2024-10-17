package calculator;

public class Exception {

    int IsNum(String s){
        try{
            Integer.parseInt(s);
            return 1;
        }
        catch(NumberFormatException e){
            return 0;
        }
    }
}
