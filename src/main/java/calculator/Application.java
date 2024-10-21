package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final String DEFAULT_DELIMITERS = ",|:"; // 기본 구분자 (쉼표, 콜론)
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"; // 커스텀 구분자 형식

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열의 경우 0 반환
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        // 커스텀 구분자가 있는 경우
        if (matcher.matches()) {
            delimiter = delimiter + "|" + matcher.group(1); // 커스텀 구분자 추출
            numbers = matcher.group(2); // 숫자 부분 추출
        }

        return sum(numbers, delimiter);
    }

    private static int sum(String numbers, String delimiter) {
        String[] tokens = numbers.split(delimiter);

        return Arrays.stream(tokens)
                .mapToInt(Application::parsePositiveInt)
                .sum();
    }

    private static int parsePositiveInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(add("1,2,3"));      // 출력: 6
        System.out.println(add("1,2:3"));      // 출력: 6
        System.out.println(add("//!\n1!2,3")); // 출력: 6
        System.out.println(add(""));           // 출력: 0
    }
}
