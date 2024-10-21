package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine().replace("\"", "").trim();

        try {
            StringAdditionCalculator calculator = new StringAdditionCalculator(input);
            int result = calculator.calculateSum();
            System.out.print("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}

class StringAdditionCalculator {
    private final String input;
    private String delimiter = ",|:";

    public StringAdditionCalculator(String input) {
        this.input = input;
        extractDelimiter();
    }

    private void extractDelimiter() {
        if (input.startsWith("//")) {
            String[] temp = input.split("\\n", 2);
            if (temp.length > 1 && temp[0].startsWith("//")) {
                delimiter = temp[0].substring(2);
            }
        }
    }

    public int calculateSum() {
        return 0;
    }
}