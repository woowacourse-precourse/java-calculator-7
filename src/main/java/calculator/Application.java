package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        int answer = calculateSum(userInput);
        System.out.println("결과 : " + answer);
            // 프로그램은 예외 발생 후 종료됩니다.
    }

    private static int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 입력된 문자열에서 "\\n"을 "\n"으로 변환
        input = input.replace("\\n", "\n");

        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            System.out.println("delimiterEndIndex: " + delimiterEndIndex);
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterEndIndex));
            numbers = input.substring(delimiterEndIndex + 1);
        }

        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            int num;
            try {
                num = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }

            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }

            sum += num;
        }

        return sum;
    }
}
