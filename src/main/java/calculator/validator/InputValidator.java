package calculator.validator;

import calculator.exception.InputException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private InputValidator() {}

    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.*)\\\\n(.*)");

    public static void checkInputNull(String input) {
        if(input == null) {
            throw new InputException("입력 값이 null 입니다.");
        }
    }

    public static Matcher checkCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);
        if(!matcher.matches()) {
            throw new InputException("커스텀 구분자 사용 형식에 맞지 않습니다.");
        }

        return matcher;
    }
}
