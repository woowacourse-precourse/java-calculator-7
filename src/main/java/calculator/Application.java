package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static String COMMA = ",";
    private static String SEMICOLON = ";";
    private static String COMMA_AND_SEMICOLON = COMMA + "|" + SEMICOLON;
    private static String EMPTY = "";

    private static String REX_ONLY_NUMBER = "\\d+";

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

        String[] delimiters = {COMMA, SEMICOLON, COMMA_AND_SEMICOLON};
        for (String delimiter : delimiters) {
            validateOnlyDelimiter(input, delimiter);
        }

        List<String> stringInputs = Arrays.stream(input.split(COMMA_AND_SEMICOLON)).toList();

        List<Integer> intParsedInputs;
        try {
            intParsedInputs = stringInputs.stream().filter(letter -> !letter.equals(EMPTY)).map(String::trim)
                    .map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {

            for (String stringInput : stringInputs) {
                boolean isNumeric = stringInput.matches(REX_ONLY_NUMBER);
                if (!isNumeric) {
                    throw new IllegalArgumentException("피연산자에 숫자가 아닌 다른 문자가 있습니다");
                }
            }

            throw new IllegalArgumentException("파싱시 Int 형식이 아닙니다");
        }

        for (int inputNumber : intParsedInputs) {
            if (inputNumber == 0) {
                throw new IllegalArgumentException("0을 포함합니다");
            }

            if (inputNumber < 0) {
                throw new IllegalArgumentException("음수를 포함합니다");
            }
        }

        return intParsedInputs.stream().reduce(0, Integer::sum);
    }

    private static void validateOnlyDelimiter(String input, String delimiter) {
        List<String> inputs = Arrays.stream(input.split(delimiter)).toList();
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException(delimiter + " 밖에 없습니다");
        }
    }
}
