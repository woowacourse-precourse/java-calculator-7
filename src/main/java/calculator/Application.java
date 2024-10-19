package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println(input);

        DelimiterParser delimiterParser = new DelimiterParser();
        NumberParser numberParser = new NumberParser();
        Calculator calculator = new Calculator();

        String delimiter = delimiterParser.getDelimiter(input);
        String s = delimiterParser.extractNumbers(input);
        int[] numbers = numberParser.parse(s, delimiter);
        int result = calculator.sum(numbers);
        System.out.println("결과 : " + result);
        scanner.close();
    }
}