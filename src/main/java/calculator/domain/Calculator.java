package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public int run() {
        String input = getInput();
        return calculate(input);
    }

    // 문자열을 입력받는 함수
    private String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    // 문자열에서 커스텀 구분자를 추출하고, 숫자를 구분자로 분리해 더하는 함수
    private int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] delimiterAndNumbers = findDelimiter(input);
        String delimiters = delimiterAndNumbers[0];
        String numbers = delimiterAndNumbers[1];

        return sum(splitNumbers(delimiters, numbers));
    }

    // 커스텀 구분자를 찾는 함수
    private String[] findDelimiter(String input) {

        String defaultDelimiter = DEFAULT_DELIMITERS;

        // 커스텀 구분자가 없다면
        if (!input.startsWith("//")) {
            String numbers = input;
            return new String[]{defaultDelimiter, numbers};
        }

        // 커스텀 구분자가 있다면
        int customDelimiterIndex = input.indexOf("\\n");

        String customDelimiter = input.substring(2, customDelimiterIndex);
        customDelimiter = Pattern.quote(customDelimiter);
        String delimiters = defaultDelimiter + "|" + customDelimiter;
        String numbers = input.substring(customDelimiterIndex + 2);
        return new String[]{delimiters, numbers};
    }

    // 정규식을 사용해 구분자와 숫자를 분리하는 함수
    private String[] splitNumbers(String delimiters, String numbers) {
        return numbers.split(delimiters);
    }

    // 분리한 숫자를 더해서 결과를 반환하는 함수
    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
