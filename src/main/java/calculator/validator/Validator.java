package calculator.validator;


import java.util.regex.Pattern;

public class Validator {

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String NON_NUMERIC_ERROR_MESSAGE = "숫자가 아닌 문자열은 허용되지 않습니다.";
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수는 허용되지 않습니다.";
    private static final String EMPTY_NUMBER_ERROR_MESSAGE = "숫자가 입력되지 않았습니다.";

    public boolean inputValidate(String input) {
        boolean chkEmpty = false;
        if (input == null || input.isEmpty()) {
            chkEmpty = true;
        }
        return chkEmpty;
    }//inputValidate

    public void numberValidate(String number) {

        if (!Pattern.matches(NUMBER_REGEX, number)) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }

        if (number.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NUMBER_ERROR_MESSAGE);
        }

        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }

    }//numberValidate
}//class
