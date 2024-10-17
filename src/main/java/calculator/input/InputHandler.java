package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final Validator validator;

    // 외부에서 Validator 를 주입받음. (의존성 주입)
    public InputHandler(Validator validator) {
        this.validator = validator;
    }

    public String getInput() {
        String input = Console.readLine();
        validator.check(input); // Validator 에서 입력 값 검증 후 반환
        return input;
    }
}
