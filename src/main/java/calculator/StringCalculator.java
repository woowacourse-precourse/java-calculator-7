package calculator;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    /**
     * 문자열 입력을 받아 덧셈을 수행합니다.
     *
     * @param input 입력 문자열
     * @return 덧셈 결과
     */
    public static int add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        input = input.trim();
        String delimiter = DEFAULT_DELIMITER;

        return sumNumbers(input.split(delimiter));
    }


    /**
     * 숫자 배열을 합산합니다.
     *
     * @param numbers 숫자 문자열 배열
     * @return 합계
     */
    private static int sumNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number.trim());
                sum += num;
            }
        }

        return sum;
    }
}
