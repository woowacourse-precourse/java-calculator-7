package calculator.validator;


import java.util.regex.Pattern;

public class Validator {

    private static final String NUMBER_REGEX = "^[0-9]*$";

    public boolean inputValidate(String input) {
        boolean chkEmpty = false;
        if (input == null || input.isEmpty()) {
            chkEmpty = true;
        }
        return chkEmpty;
    }//inputValidate

    public void numberValidate(String number) {
        if (!Pattern.matches(NUMBER_REGEX, number)) {
            throw new IllegalArgumentException("숫자가 아닌 문자열은 허용되지 않습니다.");
        }

        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }//numberValidate
}//class
