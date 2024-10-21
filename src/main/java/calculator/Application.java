package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    private static final String DEFAULT_DELIMITER = "[,:]";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) {
            System.out.println("결과: 0");
            return;
        }

        input = input.replace("\\n", "\n");
        String delimiter = DEFAULT_DELIMITER;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = "[" + input.substring(2, delimiterEndIndex) + "]";
            input = input.substring(delimiterEndIndex + 1);
        }

        List<String> numbers = List.of(input.split(delimiter));

        int result = numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("결과: " + result);
    }
}
