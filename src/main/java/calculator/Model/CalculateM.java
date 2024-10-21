package calculator.Model;

public class CalculateM {
    private static final int MAX_NUMBER = Integer.MAX_VALUE;

    public int calculate(String input) {
        validateInput(input);

        String[] parts = splitInput(input);
        String delimiter = parts[0];
        String numbers = parts[1];

        String[] numberArray = splitNumbers(numbers, delimiter);
        return sumNumbers(numberArray);
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private String[] splitInput(String input) {
        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                delimiter = input.substring(2, delimiterEndIndex);
                numbers = input.substring(delimiterEndIndex + 2);
            } else {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
        } else if (!input.contains(",") && !input.contains(":")) {
            throw new IllegalArgumentException("입력값에 구분자가 없습니다.");
        }
        if (numbers.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        return new String[]{delimiter, numbers};
    }

    private String[] splitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private int sumNumbers(String[] numberArray) {
        if (numberArray.length == 0) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        long sum = 0;
        for (String numberStr : numberArray) {
            if (!numberStr.trim().isEmpty()) {
                int number = parseNumber(numberStr);
                validateNumber(number);
                sum += number;
                if (sum > MAX_NUMBER) {
                    throw new IllegalArgumentException("합이 너무 큽니다 (최대 " + MAX_NUMBER + ")");
                }
            }
        }
        return (int) sum;
    }

    private int parseNumber(String numberStr) {
        try {
            if (numberStr.contains(".")) {
                throw new IllegalArgumentException("소수점은 허용되지 않습니다: " + numberStr);
            }
            long number = Long.parseLong(numberStr.trim());
            if (number > MAX_NUMBER) {
                throw new IllegalArgumentException("수가 너무 큽니다 (최대 " + MAX_NUMBER + "): "
                        + number);
            }
            return (int) number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + numberStr);
        }
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}