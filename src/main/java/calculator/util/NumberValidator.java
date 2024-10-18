package calculator.util;

public class NumberValidator {
    private static final NumberValidator instance = new NumberValidator();

    private NumberValidator() {

    }

    public static NumberValidator getInstance() {
        return instance;
    }

    private boolean isPositiveNumber(String maybePositiveNum) {
        return Integer.parseInt(maybePositiveNum) < 0;
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");  // 숫자로만 구성된 문자열인지 확인
    }

    public void isValid(String[] maybeNums) {
        for (String maybeNum : maybeNums) {
            if (!isNumeric(maybeNum) || isPositiveNumber(maybeNum)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
