package calculator;

public class StringAddCalculator {

    public static int add(String input) {
        InputValidator.validateNullInput(input);

        if (InputValidator.isEmptyString(input)) {
            return 0;
        }
        // 문자열 길이 검증 (기본 구분자 사용시)
        InputValidator.validateInputLength(input);
        
        return -1; // 추후 로직 추가 예정
    }
}
