package calculator.validator;

import calculator.utils.InputWithDelimiter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputValidator implements Validator<InputWithDelimiter> {

    private final String inputRegexFront = "^\\d+((";
    private final String inputRegexBack = ")(\\d+))*";

    @Override
    public boolean isValid(InputWithDelimiter value) {
        boolean isValid = true;
        Matcher matcher = Pattern.compile(
                        inputRegexFront + value.getCalculatorDelimiter().getDelimiterRegex() + inputRegexBack)
                .matcher(value.getInput());
        if (!matcher.matches()) {
            isValid = false;
        }
        if (value.getInput().equals("")) {
            isValid = true;
        }
        if (!isValid) {
            throw new IllegalArgumentException("알맞은 입력 형식이 아닙니다.");
        }
        return isValid;

    }
}
