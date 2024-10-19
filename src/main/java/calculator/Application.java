package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static void main(String[] args) {
        String input = Console.readLine();
        System.out.println("결과 : " + calculator(input));
    }

    public static int calculator(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] tokens = splitInput(input);
        int sum = 0;

        for (String token : tokens) {
            try {
                int n = Integer.parseInt(token);
                if (n < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + n);
                }
                sum += n;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자 위치 외 문자는 사용할 수 없습니다: " + token);
            }
        }

        return sum;
    }

    private static String[] splitInput(String input) {
        String delimiter = DEFAULT_DELIMITER;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다: " + input);
            }

            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
        }

        return input.split(delimiter);
    }
}
