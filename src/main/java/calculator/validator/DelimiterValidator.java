package calculator.validator;

import static calculator.util.extractDelimiters.extractDelimiters;
import static calculator.util.extractNumbersPart.extractNumbersPart;

import java.util.List;

public class DelimiterValidator {

    // 연속된 구분자가 있는지 확인 (예: ",," 또는 "::")
    public boolean hasConsecutiveDelimiters(String input, String delimiter) {
        return input.contains(delimiter + delimiter);
    }

    // 입력 값의 유효성을 검증
    public boolean containsInvalidDelimiters(String input) {
        List<String> delimiters = extractDelimiters(input);
        String numbersPart = extractNumbersPart(input);

        // 연속된 기본 구분자 체크
        for (String delimiter : delimiters) {
            if (hasConsecutiveDelimiters(numbersPart, delimiter)) {
                return true; // 연속된 구분자는 잘못된 입력
            }
        }
        return false; // 유효한 경우 false 반환
    }
}