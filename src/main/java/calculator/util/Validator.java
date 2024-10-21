package calculator.util;

public class Validator {

    public int validateNumber(String token){
        int number;
        try {
            number = Integer.parseInt(token);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(token + " : 해당 입력문자는 숫자가 아닙니다");
        }
        return checkPositiveNumber(number);
    }

    private int checkPositiveNumber(int number){
        if (number < 0){
            throw new IllegalArgumentException(number + " : 음수는 허용되지 않습니다.");
        }
        return number;
    }
}
