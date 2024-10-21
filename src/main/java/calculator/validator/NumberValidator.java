package calculator.validator;

import static calculator.util.ExtractDelimiters.extractDelimiters;
import static calculator.util.ExtractNumbersPart.extractNumbersPart;

import java.util.List;

public class NumberValidator {

    // 입력 값에 숫자와 구분자 외의 문자가 있는지 검증
    public boolean containsInvalidCharacters(String input) {
        List<String> delimiters = extractDelimiters(input);
        String numbersPart = extractNumbersPart(input);

        // 유효한 숫자와 구분자 검증
        return !validateNumberPart(numbersPart, delimiters);
    }

    // 숫자 부분을 검증하는 메서드
    private boolean validateNumberPart(String numbersPart, List<String> delimiters) {
        StringBuilder currentToken = new StringBuilder();
        boolean expectingNumber = true;
        for (int i = 0; i < numbersPart.length(); i++) {
            char c = numbersPart.charAt(i);
            if (Character.isDigit(c)) {
                currentToken.append(c);
                expectingNumber = false;
            } else {
                // 구분자인지 확인
                String delimiterFound = findDelimiter(numbersPart, i, delimiters);
                if (delimiterFound != null && !expectingNumber) {
                    i += delimiterFound.length() - 1;
                    currentToken.setLength(0); // 다음 숫자를 위한 초기화
                    expectingNumber = true;
                } else {
                    return false; // 구분자가 아니면 잘못된 입력
                }
            }
        }
        return true; // 유효한 경우 true 반환
    }

    // 주어진 위치에서 구분자를 찾는 메서드
    public static String findDelimiter(String input, int startIndex, List<String> delimiters) {
        for (String delimiter : delimiters) {
            if (input.startsWith(delimiter, startIndex)) {
                return delimiter;
            }
        }
        return null;
    }

}