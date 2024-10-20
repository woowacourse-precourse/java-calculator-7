package calculator;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] numbers = split(input);
        int sum = 0;
        for (String number : numbers) {
            int num = parseNumber(number);
            if (num <= 0) {
                throw new IllegalArgumentException();
            }
            sum += num;
        }

        return sum;
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private String[] split(String input) {
        String delimiter = "[,:]";

        if (input.startsWith("//")) {
            try {
                String[] parts = input.split("\\\\n");  // ["//;", "1;2;3"]
                String customDelimiter = parts[0].substring(2);  // "//;" -> ";"
                delimiter = delimiter.substring(0, delimiter.length() - 1) + customDelimiter + "]";  // "[,:;]"
                input = parts[1];  // "1;2;3;"
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }

        return input.split(delimiter);
    }
}
