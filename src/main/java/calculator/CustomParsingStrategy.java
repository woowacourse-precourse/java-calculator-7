package calculator;

import java.util.Arrays;

public class CustomParsingStrategy implements ParsingStrategy {
    @Override
    public int parse(String input) {
        int delimiterEnd = input.indexOf('\n');
        if (delimiterEnd == -1) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }

        String delimiter = input.substring(2, delimiterEnd);
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자를 입력해야 합니다.");
        }

        // 구분자가 한 글자이고 숫자일 때 예외 처리
        if (delimiter.length() == 1 && delimiter.matches("\\d")) {
            throw new IllegalArgumentException("1글자의 구분자는 숫자를 사용할 수 없습니다: " + delimiter);
        }

        // 구분자가 여러 글자이면서 모두 숫자인 경우 예외 처리
        if (delimiter.length() > 1 && delimiter.matches("\\d+")) {
            throw new IllegalArgumentException("모든 구분자가 숫자인 경우는 허용되지 않습니다: " + delimiter);
        }

        // 커스텀 구분자와 기본 구분자를 함께 사용
        String numbersPart = input.substring(delimiterEnd + 1);
        String[] numbers = numbersPart.split(delimiter + "|,|:");

        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    if (number.isEmpty()) { // 구분자 사이에 빈 문자열이 있을 경우 0으로 처리
                        return 0;
                    }
                    // 숫자로 변환 가능한지 확인
                    if (!number.matches("-?\\d+")) {
                        throw new IllegalArgumentException("잘못된 문자 입력: " + number);
                    }
                    int num = Integer.parseInt(number);
                    // 음수와 구분자 "-" 구분
                    if (num < 0 && !delimiter.equals("-")) { // 음수가 포함되어 있는 경우 예외 발생
                        throw new IllegalArgumentException("음수를 입력할 수 없습니다: " + num);
                    }
                    return num;
                })
                .sum(); // 숫자들의 합계 반환
    }
}
