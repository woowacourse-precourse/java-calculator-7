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

            break;
        }

        String[] split = userInput.substring(prev).split("[" + delimiter + "]");
        return sum(split);
    }

    private static int sum(String[] split) {
        int sum = 0;
        for (String c : split) {
            sum += Integer.parseInt(c);
        }

        return sum;
    }
}
