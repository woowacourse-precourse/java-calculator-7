package calculator.validator;

public class Validator {

    //문자열이 비어있는지 검사하는 메소드
    public boolean checkIsEmpty(String input) {
        //문장이 비어있으면 false, 존재하면 true
        return !input.isEmpty();
    }

    //문자열에 숫자가 존재하는지 검사하는 메소드
    public boolean checkHasNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            //숫자가 하나라도 있으면 true
            if (Character.isDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
