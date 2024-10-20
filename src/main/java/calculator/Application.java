package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String DEFAULT_DELIMITERS = ",|:"; // 쉼표 또는 콜론을 기본 구분자로 정의

    public static void main(String[] args) {
        // 사용자 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 계산 결과 출력
        int result = calculate(input);
        System.out.println("결과 : " + result);
    }

    /**
     * 문자열을 입력받아 덧셈을 계산하는 메소드
     *
     * @param input
     * @return 계산 결과
     */
    private static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers;

        numbers = split(input, DEFAULT_DELIMITERS);

        return sum(numbers);
    }

    /**
     * 문자열을 구분자로 분리하는 메소드
     *
     * @param input
     * @param delimiter
     * @return 분리된 문자열 배열
     */
    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    /**
     * 문자열 배열을 정수로 변환하여 합산하는 메소드
     *
     * @param numbers
     * @return 합산 결과
     */
    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
