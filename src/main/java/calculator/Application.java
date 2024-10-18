package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println("결과 : " + add(input));
    }

    /**
     *
     * @param input 구분자와 양수로 구성된 문자열
     * @return 문자열에 포함된 숫자의 합
     * @throws IllegalArgumentException 사용자가 잘못된 값을 입력할 경우 예외를 발생시킴
     */
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex + 2);
            }
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            sum += num;
        }

        return sum;
    }
}
