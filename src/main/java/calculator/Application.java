package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");
        } else {
            String delimiter = "[,:]";
            // 커스텀 문자열 추가 시작

            // 커스텀 문자열 추가 종료
            String[] tokens = input.split(delimiter);
            int sum = 0;
            for (String token : tokens) {
                int number = parseString(token);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력 불가합니다");
                }
                sum += number;
                System.out.println("결과 : " + sum);
            }
        }

    }

    private static int parseString(String token) {
        try {
            return Integer.parseInt(token);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
