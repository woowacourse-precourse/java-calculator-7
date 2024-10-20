package calculator;

public class Calculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        SplitString splitter = new SplitString();
        String[] numbers = splitter.splitInput(input);
        int sum = 0;

        for (String number : numbers) {
            int num = toInt(number);
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            sum += num;
        }
        return sum;
    }

    private int toInt(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
