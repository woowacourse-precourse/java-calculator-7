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

            validatePositiveNumber(split);

            return sum(split);
        }

        StringBuilder delimiter = new StringBuilder(",:");

        int prev = 0;
        for (int idx = 5; idx < userInput.length(); idx += 5) {
            String split = userInput.substring(prev, idx);

            if (split.startsWith("//") && split.endsWith("\\n")) {
                delimiter.append(split.charAt(2));
                prev = idx;
                continue;
            }

            if (split.startsWith("//") || split.endsWith("\\n")) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 에러");
            }

            break;
        }

        String[] split = userInput.substring(prev).split("[" + delimiter + "]");
        validatePositiveNumber(split);
        return sum(split);
    }

    private static void validatePositiveNumber(String[] split) {
        for (String s : split) {
            if (Integer.parseInt(s) <= 0) {
                throw new IllegalArgumentException("음수 입력 x");
            }
        }
    }

    private static int sum(String[] split) {
        int sum = 0;
        for (String c : split) {
            sum += Integer.parseInt(c);
        }

        return sum;
    }
}
