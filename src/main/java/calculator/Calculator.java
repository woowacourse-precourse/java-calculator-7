package calculator;

public class Calculator {
    private String[] delimiters = {",", ":"};

    public double calculate(String input) {
        return calculateSum(input);
    }

    private double calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(String.join("|", delimiters));
        double sum = 0;

        for (String number : numbers) {
            try {
                double num = Double.parseDouble(number.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않음");
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("지정된 구분자가 아님");
            }
        }

        return sum;
    }
}
