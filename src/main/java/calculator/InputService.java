package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public static String readLine() {
        System.out.println("숫자가 포함된 문자열을 입력하세요: ");
        try {
            String input = Console.readLine();

            String result = changeStrNlToNl(input);
            return result;

        } catch (Exception e) {
            throw new IllegalArgumentException(e);

        }

    }

    private static String changeStrNlToNl(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");

            if (newlineIndex == -1) {
                throw new IllegalArgumentException();
            }

            String delimiter = input.substring(2, newlineIndex);

            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException();
            }

        }
        // '\\n' new line 으로 인식하기 위해 변환;
        return input.replace("\\n", "\n");
    }

}
