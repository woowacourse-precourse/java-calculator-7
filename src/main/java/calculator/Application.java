package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    private static int add(String input) {
        if (input.isBlank()) {
            return 0;
        }

        String delimiter = ",:"; // 기본 구분자는 쉼표(,) 또는 콜론(:)
        if (input.startsWith("//")) {
            int index = 0;

            // 커스텀 구분자라면 문자열에서 "\n"이 있어야 함.
            if (input.contains("\\n")) {
                index = input.indexOf("\\n");
                delimiter = input.substring(2, index);

                // 커스텀 구분자는 하나의 문자여야 됨. 그보다 크면 예외처리
                if (delimiter.length() > 1) {
                    System.out.println("커스텀 구분자는 하나의 문자여야 됨. 그보다 크면 예외처리");
                }
            } else {
                System.out.println("\\n을 못찾으면 예외처리");
            }

            input = input.substring(index + 2);
        }

        String[] numbers = input.split("[" + delimiter + "]");
        return calculate(numbers);
    }
}
