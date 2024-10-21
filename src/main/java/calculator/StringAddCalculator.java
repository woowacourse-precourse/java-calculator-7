package calculator;

public class StringAddCalculator {

    public static int add(String input) {
        InputValidator.validateNullInput(input);

        if (InputValidator.isEmptyString(input)) {
            return 0;
        }

        // 커스텀 구분자 사용 시 길이 검증
        if (input.startsWith("//")) {
            InputValidator.validateCustomDelimiterInputLength(input);
        }
        // 기본 구분자 사용 시 길이 검증
        InputValidator.validateInputLength(input);

        // 음수 입력 검증
        InputValidator.validateNoNegativeNumbers(input);

        return -1; // 추후 로직 추가 예정
    }
}
