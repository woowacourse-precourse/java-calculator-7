package calculator;

public class StringAddCalculator {

    public static int add(String input) {
        if (InputValidator.isEmptyString(input)) {
            return 0;
        }
        return -1; // 추후 로직 추가 예정
    }
}
