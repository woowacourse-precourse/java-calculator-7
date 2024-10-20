package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring(2, delimiterIndex);
            numbers = input.substring(delimiterIndex + 1);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        try {
            for (String token : tokens) {
                sum += Integer.parseInt(token);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.print("결과 : " + result);
        } catch (IllegalArgumentException e) {
            return;
        }
    }
}
