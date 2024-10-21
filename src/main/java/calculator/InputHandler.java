package calculator;

public class InputHandler {
    public int processInput(String input) {
        if (input.isEmpty()) {
            // 입력이 비어있는 경우
            return 0;
        } else if (input.matches("^[0-9]*$")) {
            // 입력이 숫자로만 구성된 경우
            return Integer.parseInt(input);
        } else {
            // 입력이 숫자와 문자로 구성된 경우
            Validator validator = new Validator();
            Calculator calculator = new Calculator();
            // 커스텀 구분자 사용 시
            if (validator.validateCustomSeparator(input)) {
                String[] custom = validator.extractCustomSeparatorAndInputString(input);
                // 입력 벨리데이션
                if (validator.containsInvalidCharacters(custom[1], custom[0]) || !validator.startAndEndWithNumber(custom[1])) {
                    throw new IllegalArgumentException(
                            "올바른 입력이 아닙니다. 입력값 : "+custom[1]
                    );
                } else {
                    return calculator.calculate(custom[1], custom[0]);
                }
            } else {
                // 커스텀 구분자 미사용 시
                // 입력 벨리데이션
                if (validator.containsInvalidCharacters(input) || !validator.startAndEndWithNumber(input)) {
                    throw new IllegalArgumentException(
                            "올바른 입력이 아닙니다. 입력값 : "+ input
                    );
                } else {
                    return calculator.calculate(input);
                }
            }
        }
    }
}
