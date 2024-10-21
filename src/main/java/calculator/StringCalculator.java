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
            int num = toPositiveInt(number);
            result += num;
        }
        return result;
    }

    // 숫자들이 음수인지 확인하는 메소드
    // 만약 음수라면 -> IllegalArgumentException
    private static int toPositiveInt(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        return num;
    }

}
