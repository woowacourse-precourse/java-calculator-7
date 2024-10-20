package calculator;

public class StringCalculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numberString = input;

        if (input.startsWith("//")) {
            if (input.charAt(3) == '\\' && input.charAt(4) == 'n') {
                delimiter = String.valueOf(input.charAt(2));
                numberString = input.substring(5);
            } else {
                throw new IllegalArgumentException("유효하지 않은 구분자 형식입니다.");
            }
        }

        String[] numbers = splitString(numberString, delimiter);
        int sum = sumNumbers(numbers);

        return sum;
    }

    private String[] splitString(String numberString, String delimiter) {
        return numberString.split(delimiter, -1);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = parseNumber(number.trim());
                validateNumber(num);
                sum += num;
            }
        }
        return sum;
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 변환에 실패했습니다: " + number);
        }
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
        }
    }
}
