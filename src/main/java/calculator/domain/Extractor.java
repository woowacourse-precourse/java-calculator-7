package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITERS = "//(.*?)(\\n|$)";

    private String input;
    private final List<Integer> numbers = new ArrayList<>();

    public Extractor(String input) {
        this.input = input.trim();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 기본 구분자 사이에 어떤 값도 입력되지 않은 경우 → 예외처리하기

    /**
     * 문자열에서 숫자 추출
     */
    public void extractNumbers() {

        String delimiters = getDelimiter();
        String[] numberData = splitByDelimiter(delimiters);
        addNumber(numberData);
        validatePositiveNumber();
    }

    private String getDelimiter() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITERS).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("잘못된 구분자입니다.");
            }

            input = input.substring(matcher.end());
            return "[" + Pattern.quote(customDelimiter) + "]|" + DEFAULT_DELIMITERS;
        }
        return DEFAULT_DELIMITERS;
    }

    private String[] splitByDelimiter(String delimiters) {
        return input.split(delimiters);
    }

    private void addNumber(String[] numberData) {
        // 문자열의 각 요소가 숫자인지 판별하고 리스트에 저장
        for (String data : numberData) {
            if (!data.isEmpty()) {
                try {
                    Integer value = Integer.valueOf(data);
                    numbers.add(value);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 구분자입니다.");
                }
            }
        }
    }


    private void validatePositiveNumber() {
        // 정수 배열의 각 요소가 양수인지 판별
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
            }
        }
    }
}
