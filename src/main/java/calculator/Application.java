package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        if (input == null || input.isEmpty()) {
            System.out.println("결과 : " + 0);
            return;
        }

        String[] numbers = new StringHandler().split(input, ",|:");
        Calculator calculator = new Calculator();
        int result = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            result = calculator.add(result, num);
        }
    }
}
