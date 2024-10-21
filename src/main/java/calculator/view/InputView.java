package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern INPUT_NUMBER_PATTERN = Pattern.compile("^[^\\d\\s]+$");

    public String inputNumbers() {
        String input = Console.readLine();
        validate(input);
        return input;
    }

    private void validate(String input) {
        if (INPUT_NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자를 포함해야 합니다.");
        }
    }
}
