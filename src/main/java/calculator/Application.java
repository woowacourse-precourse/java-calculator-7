package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] lines = input.split("\\\\n");

        String separator = getSeparator(lines[0]);
        int[] numbers =  getNumbers(lines[1], separator);

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

    private static String getSeparator(String header) {
        if (header.startsWith("//")) {
            return header.substring(2);
        }

        return "[,:]";
    }
}
