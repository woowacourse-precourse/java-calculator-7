package calculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private final DelimiterValidator delimiterValidator;

    Validator(DelimiterValidator delimiterValidator) {
        this.delimiterValidator = delimiterValidator;
    }

    //구분자와 양수 이외의 문자가 입력되었는지 검사하는 메소드
    public void validateCharacters(String input) {
        String allDelimiter = delimiterValidator.getAllDelimiters();

        // 문자열 연산이 빈번하기 때문에 문자열이 길 경우 대비
        Set<Character> delimiters = new HashSet<>();
        for (char delimiter : allDelimiter.toCharArray()) {
            delimiters.add(delimiter);
        }

        String numbersSection = input.substring(delimiterValidator.getDelimiterCommandLength());
        for (char ch : numbersSection.toCharArray()) {
            if (!Character.isDigit(ch) && !delimiters.contains(ch)) {
                throw new IllegalArgumentException("양수와 구분자만 입력 가능합니다. 잘못된 입력: " + ch);
            }
        }
    }

    public void validateInteger(List<Integer> numberList) {
        for (Integer number : numberList) {
            if (number <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다: " + number);
            }
        }
    }
}
