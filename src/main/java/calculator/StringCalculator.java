package calculator;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitNumbers(input);
        return sumNumbers(numbers);
    }

    private String[] splitNumbers(String input) {
        String separator = ",|:";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterEndIndex);
            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 단일 문자여야 합니다.");
            }
            separator = customDelimiter + "|,|:";
            input = input.substring(delimiterEndIndex + 1);
        }
        return input.split(separator);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수가 포함되어 계산불가: " + num);
            }
            sum += num;
        }
        return sum;
    }
}
