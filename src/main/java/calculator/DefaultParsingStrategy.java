package calculator;

import java.util.Arrays;

public class DefaultParsingStrategy implements ParsingStrategy {
    @Override
    public int parse(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split(",|:");
        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    if (number.isEmpty()) { // 구분자 사이에 빈 문자열이 있을 경우 0으로 처리
                        return 0;
                    }
                    // 공백을 포함하거나 숫자와 구분자 외 다른 문자가 포함되어 있는지 확인
                    if (!number.matches("-?\\d+")) {
                        throw new IllegalArgumentException("잘못된 문자 입력: " + number);
                    }
                    int num = Integer.parseInt(number); // 문자열을 숫자로 변환
                    if (num < 0) { // 음수가 포함되어 있는 경우 예외 발생
                        throw new IllegalArgumentException("음수를 입력할 수 없습니다: " + num);
                    }
                    return num;
                })
                .sum(); // 숫자들의 합 반환
    }
}
