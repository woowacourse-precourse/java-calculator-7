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

        String delimiter = DelimiterParser.getDelimiter(input);
        String numbers = DelimiterParser.extractNumbers(input);
        int[] parsedNumbers = NumberParser.parse(numbers, delimiter);
        int result = Calculator.sum(parsedNumbers);

        System.out.println("결과 : " + result);
        scanner.close();
    }
}