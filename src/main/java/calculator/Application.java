package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println("결과 : " + calculate(input));
        Console.close();
    }

    public static int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",:";
        String[] splitInputs = input.split(String.format("[%s]", delimiter));
        int sum = 0;
        for (String splitInput : splitInputs) {
            int number = Integer.parseInt(splitInput);
            sum += number;
        }
        return sum;
    }
}