package calculator;

public class StringCalculator {
    public String[] splitString(String input, String delimiter) {
        return input.split(delimiter);
    }

    public int stringtToInt(String number){
        try{
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new NumberFormatException("올바르지 않은 숫자 형식입니다.");
        }
    }

}
