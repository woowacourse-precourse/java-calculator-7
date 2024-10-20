package calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ":|,";
        String numberString = numbers;

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\\n");
            if (isCustomed(delimiterEndIndex)) {
                delimiter = numbers.substring(2, delimiterEndIndex);
                numberString = numbers.substring(delimiterEndIndex + 1);
            }
        }

        int sum = 0;

        String[] tokens = splitNumbers(numberString, delimiter);
        for (String token : tokens) {
            if (!isNumeric(token)) {
                throw new IllegalArgumentException("잘못된 입력입니다: " + token);
            }

            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += number;
        }
        return sum;
    }

    private static boolean isCustomed(int delimiterEndIndex) {
        return delimiterEndIndex != -1;
    }

    private String[] splitNumbers(String numberString, String delimiter) {
        return numberString.split(delimiter);
    }

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
