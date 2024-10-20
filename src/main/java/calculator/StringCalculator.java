package calculator;

public class StringCalculator {

    public int add(String input) {
        System.out.println("입력된 값: '" + input + "'");
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers = parseInput(input);
        return calculateSum(numbers);
    }

    private String[] parseInput(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다. \\n이 필요합니다.");
            }

            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
        }

        return input.split(delimiter);
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            validateNumber(number);
            int num = Integer.parseInt(number.trim());
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            sum += num;
        }
        return sum;
    }

    private void validateNumber(String number) {
        try {
            Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식의 값이 포함되어 있습니다: " + number);
        }
    }
}
