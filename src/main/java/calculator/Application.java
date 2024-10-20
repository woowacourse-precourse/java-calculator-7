package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
        System.out.println("덧셈할 문자열을 입력해 주세요.:");
        String inputString = Console.readLine();
        String[] tokens = inputString.split("[,:]");

        System.out.println("분리된 값들:");
        for (String token : tokens) {
            System.out.println(token);
        }

            List<Integer> numbers = convertToIntegers(tokens);

            System.out.println("변환된 정수들:");
            for (int number : numbers) {
                System.out.println(number);
            }

        } catch (IllegalArgumentException e) {
            System.err.println("입력 값이 잘못되었습니다: " + e.getMessage());
        }
    }

    private static List<Integer> convertToIntegers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            String trimmedToken = token.trim();
            if (trimmedToken.isEmpty()) {
                continue;
            }
            try {
                int number = Integer.parseInt(trimmedToken);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: '" + trimmedToken + "'");
            }
        }
        return numbers;
    }
}