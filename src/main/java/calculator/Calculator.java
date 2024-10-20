package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private static final Character[] DEFAULT_DELIMITERS = {',', ':'};

    /**
     * 구분자로 문자열을 나누어 정수로 변환한 후 합을 반환한다.
     * 기본 구분자: ',', ':'
     */
    public static int calculate(String s){

        if (s == null) {
            return 0;
        }

        List<Character> delimiters = List.of(DEFAULT_DELIMITERS);
        
        List<Integer> numbers = parse(s, delimiters);

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
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
