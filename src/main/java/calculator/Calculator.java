package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public int process() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        if (userInput.trim().isBlank()) {
            return 0;
        }

        if (!userInput.startsWith("//")) {
            String delimiter = ",:";
            String[] split = userInput.split("[" + delimiter + "]");

            int sum = 0;
            for (String c : split) {
                sum += Integer.parseInt(c);
            }

            return sum;
        }

        return 0;
    }
}
