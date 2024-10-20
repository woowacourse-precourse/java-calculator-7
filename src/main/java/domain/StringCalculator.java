package domain;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            System.out.println("Input: " + input);
            System.out.println(delimiterEndIndex);
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring(2, delimiterEndIndex);
            numbers = input.substring(delimiterEndIndex + 2);
        }

        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            if (!token.matches("\\d+")) {
                throw new IllegalArgumentException();
            }

            int num = Integer.parseInt(token);
            if (num < 0) {
                throw new IllegalArgumentException();
            }

            sum += num;
        }

        return sum;
    }
}
