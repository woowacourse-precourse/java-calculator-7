package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            if (input == null || input.isEmpty()) {
                System.out.println("결과 : 0");
                return;
            }

            String delimiter = ",|:";

            if (input.startsWith("//")) {
                int delimiterIndex = input.indexOf("\n");
                delimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex + 1);
            }

            String[] numbers = input.split(delimiter);
            int sum = 0;

            for (String number : numbers) {
                int num = Integer.parseInt(number);
                sum += num;
            }

            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
