package calculator.util;

public class NumberValidator {

    public int validateNumber(String token){
        int number;
        try {
            number = Integer.parseInt(token);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다" + token);
        }
        return checkPositiveNumber(number);
    }

    private int checkPositiveNumber(int number){
        if (number < 0){
            throw new IllegalArgumentException("음수는 허용되지 않습니다." + number);
        }
        return number;
    }
}
