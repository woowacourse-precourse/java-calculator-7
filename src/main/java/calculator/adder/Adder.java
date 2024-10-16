package calculator.adder;

import calculator.delimiter.Delimiter;

public class Adder {
    private final Delimiter delimiter;

    public Adder() {
        this.delimiter = new Delimiter();
    }

    public int addInput(String input) {
        if (input.startsWith("//")) {
            input = delimiter.addCustomDelimiter(input);
        }

        if (input.isEmpty()) {
            return 0;
        }

        String[] inputList = input.split(delimiter.getDel());
        int sum = 0;
        for (String s : inputList) {
            int num;
            try {
                num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if (num <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
            sum += num;
        }
        return sum;
    }
}
