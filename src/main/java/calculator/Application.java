package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}

class StringCalculator {
    public static int add(String input) {
        if(input == null || input.isEmpty())
            return 0;

        String delimiter = ",|:";
        String[] numbers = input.split(delimiter);

        int sum = 0;
        for(String number : numbers) {
            int num = Integer.parseInt(number);
            sum += num;
        }
        return sum;
    }
}