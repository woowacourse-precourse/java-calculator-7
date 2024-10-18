package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println("결과 : " + add(input));
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split("[,:]");
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
