package calculator.util;

public class StringArrayValidator extends Validator<String[]> {
    private static final StringArrayValidator instance = new StringArrayValidator();

    private StringArrayValidator() {

    }

    public static StringArrayValidator getInstance() {
        return instance;
    }

    private boolean isPositiveNumber(String maybePositiveNum) {
        return Integer.parseInt(maybePositiveNum) < 0;
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");  // 숫자로만 구성된 문자열인지 확인
    }

    @Override
    public void isValid(String[] maybeNums) {
        for (String maybeNum : maybeNums) {
            if (!isNumeric(maybeNum) || isPositiveNumber(maybeNum)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
