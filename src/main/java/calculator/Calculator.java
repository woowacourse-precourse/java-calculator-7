package calculator;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 쉼표(,)와 콜론(:)을 구분자로 사용하여 숫자를 분리
        String[] numbers = input.split(",|:");
        return calculateSum(numbers); // 분리된 숫자 배열을 합산
    }

    // 숫자 배열을 합산하는 메서드
    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}
