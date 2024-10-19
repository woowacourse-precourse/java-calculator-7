package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringTokenizer;

public class Application {

    private static final String DEFAULT_DELIMITERS = ",:";
    private static String delimiters = DEFAULT_DELIMITERS;
    private static int sum = 0;

    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = readInputString();

            input = checkCustomDelimiter(input);

            addAllNumbers(input);

            System.out.println("결과 : " + sum);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input provided for addition operation.", e);
        }
    }

    private static String readInputString() {
        return Console.readLine();
    }

    private static String checkCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            delimiters = input.charAt(2) + "";
            return input.substring(5);
        }
        return input;
    }

    private static void addAllNumbers(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, delimiters);
        while (tokenizer.hasMoreTokens()) {
            sum += Integer.parseInt(tokenizer.nextToken());
        }
    }
}