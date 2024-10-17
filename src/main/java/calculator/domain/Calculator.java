package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public Calculator() {
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        System.out.println("결과 : " + sum(Console.readLine()));
    }

    private String checkDelimiter(String input) {
        String delimiter = "[,;]";

        if (input.startsWith("//")) {

            if (!input.contains("\\n")) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring("//".length(), input.indexOf("\\n"));
        }
        return delimiter;
    }

    private String[] splitNumber(String input) {
        String delimiter = checkDelimiter(input);

        if (!delimiter.equals("[,;]")) {
            input = input.substring(input.indexOf("\\n") + "\\n".length());
        }

        return input.split(delimiter);
    }

    private int sum(String input) {
        String[] splitNumbers = splitNumber(input);

        int sum = 0;
        for (String number : splitNumbers) {
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
