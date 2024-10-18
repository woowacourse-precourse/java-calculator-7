package calculator;

public class Calculator {

    public String calculateSum(String[] numbers) {
        StringBuilder result = new StringBuilder();
        int maxLength = getMaxLength(numbers);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = padWithZeros(numbers[i], maxLength);
        }

        int carry = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = carry;
            for (String number : numbers) {
                int digit = number.charAt(i) - '0';
                isDigit(number);
                sum += digit;
            }
            carry = sum / 10;
            result.append(sum % 10);
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    private int getMaxLength(String[] numbers) {
        int maxLength = 0;
        for (String number : numbers) {
            maxLength = Math.max(maxLength, number.length());
        }
        return maxLength;
    }

    private String padWithZeros(String input, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length(); i < length; i++) {
            sb.append('0');
        }
        sb.append(input);
        return sb.toString();
    }

    private void isDigit(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("잘못된 입력: " + input);
            }
        }
    }

}
