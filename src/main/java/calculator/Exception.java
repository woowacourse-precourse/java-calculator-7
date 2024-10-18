package calculator;

public class Exception {

    int IsPositiveNum(String s){
        try{
            if(s == ""){
                throw new NumberFormatException();
            }
            int num = Integer.parseInt(s);
            if(num < 0){
                throw new NumberFormatException();
            }
            return num;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }


}
