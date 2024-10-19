package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public static String readLine() {
        System.out.println("숫자가 포함된 문자열을 입력하세요: ");
        String input = changeEmptyToZero(Console.readLine());
        String result = changeStrNlToNl(input);

        return result;
    }

    private static String changeEmptyToZero(String input) {
        return input.isEmpty() ? "0" : input;
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
