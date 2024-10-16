package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public long add(String input) {
        if (input == null || input.isEmpty()) {
            return 0L;
        }

        String[] parts = parseInput(input);
        return sumNumbers(parts);
    }


    public static void main(String[] args) {
        Application calculator = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자로부터 입력을 받음

        try {
            long result = calculator.add(input);
            System.out.println("결과 : " + result);
        } finally {
            Console.close();
        }
    }
}
