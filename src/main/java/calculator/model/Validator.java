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

    public static void checkCustomDelimiter(int index){
        if(index == -1 ){
            throw new IllegalArgumentException("커스텀 구분자 지정 형식이 잘못 되었습니다.");
        }
    }
}
