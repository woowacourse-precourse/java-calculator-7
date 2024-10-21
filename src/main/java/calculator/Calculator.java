package calculator;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        if (input.startsWith("//")) {  // 커스텀 구분자 처리
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);  // 구분자를 추출
            input = input.substring(delimiterIndex + 1);     // 숫자 부분만 추출
        }

        String[] numbers = input.split(delimiter);
        return calculateSum(numbers);
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 0) {  // 음수일 경우 예외 발생
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
            sum += num;
        }
        return sum;
    }
}
