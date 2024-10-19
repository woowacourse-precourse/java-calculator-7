package calculator.input;

import calculator.parse.StringParser;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final Validator validator;
    private final StringParser stringParser;

    public InputHandler(Validator validator, StringParser stringParser) {
        this.validator = validator;
        this.stringParser = stringParser;
    }

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 커스텀 구분자가 포함되어 있으면 추출 후 검증
        if (validator.hasCustomDelimiter(input)) {
            String customDelimiter = stringParser.getCustomDelimiter(input);
            validator.check(input, customDelimiter);

            return input;
        }

        validator.check(input); // 기본 검증 후 반환
        return input;
    }
}