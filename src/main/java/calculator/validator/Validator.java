package calculator.validator;

import java.util.ArrayList;

public class Validator {

    //문자열이 비어있는지 검사
    public boolean checkIsEmpty(String input) {
        //문장이 비어있으면 false, 존재하면 true
        return !input.isEmpty();
    }

    //문자열에 숫자가 존재하는지 검사
    public boolean checkHasNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            //숫자가 하나라도 있으면 true
            if (Character.isDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    //커스텀 구분자를 사용하였는지 검사
    public boolean checkCustomSeparator(String input, ArrayList<String> separator) {
        if (input.charAt(0) != '/' && input.charAt(1) != '/') {
            return true;
        }
        for (int i = 2; i < input.length(); i++) {
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                separator.add(input.substring(2, i));
                return true;
            }
        }
        return false;
    }
}
