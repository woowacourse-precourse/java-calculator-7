package calculator.validator;

public class NumberValidator {
    public boolean isNumberOrSeparator(String number) {
        if (!(number.matches("\\d+"))) {
            throw new IllegalArgumentException("숫자 문자열에 숫자 또는 구분자가 아닌 문자가 포함되었습니다.");
        }
        return true;
    }
}
