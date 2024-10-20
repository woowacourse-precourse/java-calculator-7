package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private static final Character[] DEFAULT_DELIMITERS = {',', ':'};
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    /**
     * 구분자로 문자열을 나누어 정수로 변환한 후 합을 반환한다.
     * 기본 구분자: ',', ':'
     */
    public static int calculate(String s){

        if (s == null) {
            return 0;
        }

        List<Character> delimiters = new ArrayList<>(List.of(DEFAULT_DELIMITERS));
        if (hasCustomDelimiter(s)) {
            delimiters.add(s.charAt(CUSTOM_DELIMITER_PREFIX.length()));
            s = s.substring(CUSTOM_DELIMITER_PREFIX.length() + CUSTOM_DELIMITER_SUFFIX.length() + 1);
        }

        List<Integer> numbers = parse(s, delimiters);

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean hasCustomDelimiter(String s) {
        return s.length() >= CUSTOM_DELIMITER_PREFIX.length() + CUSTOM_DELIMITER_SUFFIX.length() + 1 &&
                s.startsWith(CUSTOM_DELIMITER_PREFIX) &&
                s.startsWith(CUSTOM_DELIMITER_SUFFIX, CUSTOM_DELIMITER_PREFIX.length() + 1);
    }

    private static List<Integer> parse(String s, List<Character> delimiters) {

        List<String> tokens = split(s, delimiters);

        return tokens.stream()
                .map(Calculator::parseInt)
                .collect(Collectors.toList());
    }

    private static List<String> split(String s, List<Character> delimiters) {

        String rex = delimiters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("", "[", "]"));

        return List.of(s.split(rex, -1));
    }

    private static int parseInt(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        int number;
        try {
            number = Integer.parseInt(s);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 있습니다.");
        }

        return number;
    }
}
