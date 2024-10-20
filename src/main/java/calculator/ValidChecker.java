package calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

public class ValidChecker {
    public void emptyStringCheck(String input) {      // 빈 문자열 처리
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void numberCheck(String[] input) {     // 숫자가 아닌 문자 확인
        Optional<String> findChar = Arrays.stream(input)
                .filter(s -> !s.matches("-?\\d+"))
                .findFirst();

        if (findChar.isPresent()) {
            throw new IllegalArgumentException();
        }
    }

    public void delimiterCheck(String[] input) {   // 구분자가 연속해서 두 개인 경우 (비어있는 문자열이 분리된 문자열에 포함되어 있음)
        Optional<String> findEmpty = Arrays.stream(input)
                .filter(String::isEmpty)
                .findFirst();

        if (findEmpty.isPresent()) {
            throw new IllegalArgumentException();
        }
    }

    public void lastCharCheck(String input, String delimiter) {   // 맨 끝 문자가 구분자인 경우
        String pattern = delimiter + "$";

        if (input.matches(".*" + pattern)) {
            throw new IllegalArgumentException();
        }
    }

    public void customDelimiterNumCheck(String delimiter) {   // 커스텀 구분자가 숫자인 경우
        if (delimiter.matches("-?\\d+")) {
            throw new IllegalArgumentException();
        }
    }
}
