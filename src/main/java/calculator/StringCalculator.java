package calculator;

public class StringCalculator {
    public static int add(String input) {

        String delimiter = ",|:"; // 구분자

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(delimiter); // 더할 숫자들만 모여 있는 배열
        return sum(numbers);
    }

    // 숫자들을 모두 더하는 메소드
    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }


}
