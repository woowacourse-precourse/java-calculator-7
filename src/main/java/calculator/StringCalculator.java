package calculator;

public class StringCalculator {
    public int add(String input) {
        String[] numbers = split(input);

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private String[] split(String input) {
        String delimiter = "[,:]";

        if (input.startsWith("//")) {
            String[] parts = input.split("\\\\n");  // ["//;", "1;2;3"]

            String customDelimiter = parts[0].substring(2);  // "//;" -> ";"
            delimiter = delimiter.substring(0, delimiter.length() - 1) + customDelimiter + "]";  // "[,:;]"
            input = parts[1];  // "1;2;3;"
        }

        return input.split(delimiter);
    }
}
