package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        System.out.println("결과 : " + calculator(Console.readLine()));
    }

    private static int calculator(String input) throws IllegalArgumentException{

        String delimiter = "[,;]";

        if (input.startsWith("//")) {

            if (!input.contains("\\n")) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring("//".length(), input.indexOf("\\n"));
            input = input.substring(input.indexOf("\\n") + "\\n".length());
        }

        String[] numbers = input.split(delimiter);

        int sum = 0;
        for (String number : numbers) {

            try {
                if (Integer.parseInt(number) < 0) {
                    throw new IllegalArgumentException();
                }
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return sum;
    }
}
