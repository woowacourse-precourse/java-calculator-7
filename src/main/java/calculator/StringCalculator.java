package calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numberString = numbers;

        if (numbers.startsWith("//")) {
            delimiter = Character.toString(numbers.charAt(2));
            numberString = numbers.substring(5);
        }

        String[] tokens = splitNumbers(numberString, delimiter);
        int sum = 0;

        for (String token : tokens) {
            String trimmedToken = token.trim();

            if (!isNumeric(trimmedToken)) {
                throw new IllegalArgumentException("잘못된 입력입니다: " + trimmedToken);
            }
            int number = Integer.parseInt(trimmedToken);

            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += number;
        }

        return sum;
    }

    private String[] splitNumbers(String numberString, String delimiter) {
        String[] tokens = numberString.split("[,\n;]");
        return tokens;
    }

    // 숫자인지 확인하는 메서드
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
