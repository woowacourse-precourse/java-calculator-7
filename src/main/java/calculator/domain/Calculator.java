package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final String calculatorString;

    public Calculator(String calculatorString) {
        this.calculatorString = calculatorString;
    }

    // 합을 계산하는 메서드
    public int calculateNumbers() {
        if (calculatorString == null || calculatorString.isEmpty()) {
            return 0;  // 빈 문자열의 경우 0 반환
        }

        // 커스텀 구분자가 있는지 확인
        Matcher customDelimiterMatcher = Pattern.compile("//(.)\n(.*)").matcher(calculatorString);
        String[] numbers;

        if (customDelimiterMatcher.matches()) {
            numbers = splitWithCustomDelimiter(customDelimiterMatcher);
        } else {
            numbers = splitWithDefaultDelimiters();  // 기본 구분자로 분리
        }

        return sumNumbers(numbers);
    }

    // 숫자의 배열을 합산하는 메서드
    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String numString : numbers) {
            int number = Integer.parseInt(numString.trim());
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            sum += number;
        }
        return sum;
    }

    // 기본 구분자로 분리하는 메서드 (쉼표와 콜론)
    private String[] splitWithDefaultDelimiters() {
        return calculatorString.split("[,|:]");
    }

    // 커스텀 구분자로 분리하는 메서드
    private String[] splitWithCustomDelimiter(Matcher customDelimiterMatcher) {
        String customDelimiter = customDelimiterMatcher.group(1);  // 커스텀 구분자 추출
        String numbers = customDelimiterMatcher.group(2);  // 나머지 숫자들 추출
        return numbers.split(Pattern.quote(customDelimiter));  // 커스텀 구분자로 분리
    }
}
