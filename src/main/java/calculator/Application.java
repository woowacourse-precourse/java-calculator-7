package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static String COMMA = ",";
    private static String SEMICOLON = ";";

    public static void main(String[] args) {
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    private static int add(String input) {
        boolean isNotContainingDelimiter = !input.contains(COMMA) && !input.contains(SEMICOLON);

        if (input.isEmpty()) {
            return 0;
        }
        if (isNotContainingDelimiter) {
            throw new IllegalArgumentException("구분자가 없습니다");
        }

        String[] delimiters = {COMMA, SEMICOLON, COMMA + "|" + SEMICOLON};
        for (String delimiter : delimiters) {
            validateOnlyDelimiter(input, delimiter);
        }

        List<Integer> inputs = Arrays.stream(input.split(COMMA + "|" + SEMICOLON))
                .filter(letter -> !letter.equals(""))
                .map(Integer::parseInt)
                .toList();

        for (int inputNumber : inputs) {
            if (inputNumber < 0) {
                throw new IllegalArgumentException("음수를 포함합니다");
            }
        }

        return inputs.stream()
                .reduce(0, Integer::sum);
    }

    private static void validateOnlyDelimiter(String input, String delimiter) {
        List<String> inputs = Arrays.stream(input.split(delimiter)).toList();
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException(delimiter + " 밖에 없습니다");
        }
    }
}
