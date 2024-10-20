package calculator;

import java.util.stream.Stream;

public class StringCalculator {
    private final InputValidator validator;

    public StringCalculator() {
        this.validator = new InputValidator();
    }

    private String normalizeDelimiter(String input) {
        String[] split = input.split("\\\\n");

        String delimiter = split[0].replace("//", "");
        String numbers = split[1];

        input = numbers.replace(delimiter, ",");
        return input;
    }

    public int calculate(String input) {
        //계산로직: 커스텀구분자를 일반구분자로 변경
        if (input.startsWith("//")) {
            input = normalizeDelimiter(input);
        }

        //사용자 입력 검증
        char[] charArray = input.toCharArray();
        validator.isPositiveNumber(charArray);
        validator.isDelimiter(charArray);

        //계산로직: 구분자 기준으로 숫자 추출
        String[] split1 = input.split(",|:");

        //계산로직: 숫자의 합 구하기
        int resultSum = Stream.of(split1).mapToInt(Integer::parseInt).sum();

        return resultSum;
    }
}

