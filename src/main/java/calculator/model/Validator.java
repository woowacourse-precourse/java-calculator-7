package calculator.model;

public class Validator {

    public static int validate(String token){
        try{
            int number = Integer.parseInt(token);
            if(number < 1){
                throw new IllegalArgumentException("음수가 포함되어 있습니다.");
            }
            return number;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }
}
