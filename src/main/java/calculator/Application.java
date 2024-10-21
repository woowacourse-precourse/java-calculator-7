package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void throwException() {
        throw new IllegalArgumentException();
    }

    public static String extractCustomDelimiter(String input) {
        if (!input.startsWith("//")) {
            return "";
        } else {
            int startOfCustomDelimiter = input.indexOf("\\n");

            if (startOfCustomDelimiter == -1) {
                throwException();
            }

            String customDelimiter = input.substring("//".length(), startOfCustomDelimiter);

            if (customDelimiter.matches(".*[0-9].*") || customDelimiter.length() > 1) {
                throwException();
            }

            return customDelimiter;
        }
    }

    public static int calculateSum(String[] numbers) {
        int sum = 0, value = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {
                    value = Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    throwException();
                }

                if (value < 0) {
                    throwException();
                }
                
                sum += value;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String delimiter = ",|:";
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (!input.isEmpty()) {
            String customDelimiter = extractCustomDelimiter(input);

            if (!customDelimiter.isEmpty()) {
                input = input.substring(5);
                delimiter += "|" + customDelimiter;
            }

            String[] numbers = input.split(delimiter);
            result = calculateSum(numbers);
        }

        System.out.println("결과 : " + result);
    }
}
