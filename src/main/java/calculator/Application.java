package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String sep = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int sepIndex = input.indexOf("\n");
            if (sepIndex == -1) {
                throw new IllegalArgumentException();
            }
            sep = input.substring(2, sepIndex);
            numbers = input.substring(sepIndex + 1);
        }

        String[] units = numbers.split(sep);
        int sum = 0;

        try {
            for (String unit : units) {
                if (!unit.isEmpty()) {
                    sum += Integer.parseInt(unit);
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            return;
        }
    }
}
