package calculator;


public class Calculator {
    private Delimiter delimiter;
    private String input = "";
    private long result = 0L;

    public Calculator(Delimiter delimiter, String input) {
        this.delimiter = delimiter;
        this.input = input;
    }

    public long calculate() {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(delimiter.getRegex());

        for (String number : numbers) {
            if (number.equals("")) {
                continue;
            }
            result += convertToNumber(number);
        }
            return result;
    }

    private int convertToNumber(String number) {
        try {
            int value = Integer.parseInt(number);
            validPositiveNumber(value);
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validPositiveNumber(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
