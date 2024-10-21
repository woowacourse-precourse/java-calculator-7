package calculator;

public class StringCalculator {
    public static int addition(String input) {
        String seperator = ",:";

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }


        if (input.startsWith("//") && input.contains("\\n")) {
            int idx = input.indexOf("\\n");
            seperator += input.substring(2, idx);
            input = input.substring(idx + 2);
        }

        String[] numbers = input.split("[" + seperator + "]");

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
