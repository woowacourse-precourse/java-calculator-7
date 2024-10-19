package calculator.view;

import calculator.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern REGULAR_EXPRESSION = Pattern.compile("^(\\d+([,:]\\d+)*)?$");
    private static final Pattern REGULAR_EXPRESSION_CUSTOM_DELIMITER = Pattern.compile(
            "^\\/\\/(.)\\\\n(\\d+)?(([,:]|\\1)\\d+)*");
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String getInput() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        validateNull(input);
        validateByRegex(input);
        return input;
    }

    private void validateNull(String string) {
        if (string == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
    }

    private void validateByRegex(String input) {
        if (!REGULAR_EXPRESSION.matcher(input).matches() &&
                !REGULAR_EXPRESSION_CUSTOM_DELIMITER.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.REGEX_NOT_MATCH_INPUT.getMessage());
        }
    }
}