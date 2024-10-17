package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        System.out.println(calculateNum(input));
    }

    private static int calculateNum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String separator = ",|:";

        int customSepStartIndex = input.indexOf("//");
        if (customSepStartIndex != -1) {
            int customSepEndIndex = input.indexOf("\n", customSepStartIndex);

            if (customSepEndIndex != -1) {
                String customSep = input.substring(customSepStartIndex + 2, customSepEndIndex);
                separator = customSep;

                input = input.substring(0, customSepStartIndex) + input.substring(customSepEndIndex + 1);
            }
        }

        String[] numbers = input.split(separator);

        int sum = 0;
        for (String number : numbers) {
            sum += parseNumber(number);
        }

        return sum;
    }

    private static int parseNumber(String number) {
        int result;
        try {
            result = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
        if (result < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return result;
    }
}