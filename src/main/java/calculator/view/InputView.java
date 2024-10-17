package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern INPUT_PATTERN = Pattern.compile("^//[^\\d,:]\\n\\d+([,:]\\d+)*$");
    private static final String INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 입력 형식입니다";

    public String inputString() {
        String input = Console.readLine();
        Console.close();

        validateString(input);
        return input;
    }

    public void validateString(String input) {
        if (!INPUT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
