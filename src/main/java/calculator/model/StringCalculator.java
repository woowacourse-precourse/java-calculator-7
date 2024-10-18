package calculator.model;

public class StringCalculator {
    public static int sumNumbers(String inputValue, String delimiter) {
        String[] numbers = inputValue.split(delimiter);
        int sum = 0;
        for (String numStr : numbers) {
            sum += Integer.parseInt(numStr.trim()); // 숫자로 변환 후 합산
        }
        return sum;
    }
}
