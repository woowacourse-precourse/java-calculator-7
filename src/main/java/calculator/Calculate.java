package calculator;
public class Calculate {

    public static int sum(String input) {
        if (input.startsWith("//")) {
            return customChar(input);
        }

        return calculate(input, "[,:]");
    }

    private static int customChar(String input) {
        int start = input.indexOf("//") + 2;
        int end = input.indexOf("\\n");
        if (end == -1) {
            throw new IllegalArgumentException();
        }

        String customDelimiter = input.substring(start, end);
        String numbers = input.substring(end + 2);

        return calculate(numbers, customDelimiter);
    }

    private static int calculate(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            int num = check(number);
            sum += num;
        }

        return sum;
    }

    private static int check(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
