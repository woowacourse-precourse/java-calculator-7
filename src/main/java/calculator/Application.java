package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final String SEPARATOR_PATTERN = "//(.+)\\\\n";
    private static final String DEFAULT_SEPARATOR = "[,:]";

    public static void main(String[] args) throws IOException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        boolean customSeparatorDefined = Pattern.compile(SEPARATOR_PATTERN)
                .matcher(input)
                .find();
        String separator = customSeparatorDefined ? getSeparator(input) : DEFAULT_SEPARATOR;
        String numbersString = customSeparatorDefined ? input.split("\\\\n", 2)[1] : input;

        int[] numbers =  getNumbers(numbersString, separator);
        int result = Arrays.stream(numbers)
                .sum();

        System.out.println("결과 : " + result);
    }

    private static int[] getNumbers(String input, String separator) {
        String[] tokens = input.split(separator);
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            validateNumber(tokens[i]);
            numbers[i] = Integer.parseInt(tokens[i]);
        }

        return numbers;
    }

    private static void validateNumber(String number) {
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private static String getSeparator(String input) {
        Matcher matcher = Pattern.compile(SEPARATOR_PATTERN)
                .matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return DEFAULT_SEPARATOR;
    }
}
