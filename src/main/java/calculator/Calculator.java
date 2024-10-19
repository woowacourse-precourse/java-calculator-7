package calculator;

public class Calculator {
    public static int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        // input이 빈 문자열이 아닌 경우
        String[] parsedNumber = Parser.parse(input);
        for (String number : parsedNumber) {
            System.out.println(number);
        }

        return 1;
    }
}
