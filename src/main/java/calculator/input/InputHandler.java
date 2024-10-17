package calculator.input;

import calculator.parse.StringParser;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final Validator validator;
    private final StringParser stringParser;

    // 외부에서 validator, stringParser 주입받음. (의존성 주입)
    public InputHandler(Validator validator, StringParser stringParser) {
        this.validator = validator;
        this.stringParser = stringParser;
    }

    public String getInput() {
        String input = Console.readLine(); // 사용자에게 값을 입력 받음

        // Validator 을 통해서 검증
        if (validator.hasCustomDelimiter(input)) {
            String customDelimiter = stringParser.getCustomDelimiter(input);
            validator.check(input, customDelimiter);
        } else {
            validator.check(input);
        }

        // 올바른 입력 값 반환
        return input;
    }
}
