package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        String[] numbers = parseNumbers(input);
        if (numbers.length == 1) {
            System.out.println("결과 : " + numbers[0]);
            return;
        }

        System.out.println("결과 : " + calculateResult(numbers));
    }

    private static String[] parseNumbers(String input) {
        NumberParserFactory numberParserFactory = new NumberParserFactory();
        return numberParserFactory.parseString(input);
    }

    private static int calculateResult(String[] numbers) {
        StringCalculator stringCalculator = new StringCalculator();
        return stringCalculator.calculate(numbers);
    }
}
