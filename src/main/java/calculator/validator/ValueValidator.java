package calculator.validator;

import static calculator.util.extractNumbersPart.extractNumbersPart;

public class ValueValidator {

    // 입력 값이 비어있는지 검증
    public boolean hasValue(String input) {
        String numbersPart = extractNumbersPart(input);
        return !numbersPart.isEmpty();
    } // 0으로 출력

    // 마지막 문자가 숫자인지 확인
    public boolean isLastDigit(String input) {
        String numbersPart = extractNumbersPart(input);
        return Character.isDigit(numbersPart.charAt(numbersPart.length() - 1));
    }
}