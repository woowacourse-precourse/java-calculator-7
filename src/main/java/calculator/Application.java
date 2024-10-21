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

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자의 입력 형식에 맞게 작성해 주세요.");
            } else if (delimiterIndex == 2) {
                throw new IllegalArgumentException("사용할 커스텀 구분자를 입력해 주세요.");
            }

            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
            if (input.isEmpty()) {
                return 0;
            }
        }

        String[] splitInputs = input.split(String.format("[%s]", delimiter));
        int sum = 0;
        for (String splitInput : splitInputs) {
            int number = Integer.parseInt(splitInput);
            sum += number;
        }
        return sum;
    }
}