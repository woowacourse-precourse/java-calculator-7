package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] result = extractCustomDelimiter(input);
    }

    public static String[] extractCustomDelimiter(String input) {
        String delimiter = ",|:";
        String numberString = input;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);
                numberString = input.substring(delimiterIndex + 1);
            }
        }

        return new String[]{delimiter, numberString};
    }
}
