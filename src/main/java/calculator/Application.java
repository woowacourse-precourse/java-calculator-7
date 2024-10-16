package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // Get input
        String input = readLine();

        try {
            int result = getResult(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }

    private static int getResult(String input) {
        // 비어있을 경우 0을 반환하자 (3.1 예외)
        if (input.isEmpty()) {
            return 0;
        }
        /**
         * 1-1. 기본 구분자만 입력된 경우
         */
        String delimiter = "[,:]";
        String numberPart = input;

        /**
         * 1.2 커스텀 구분자를 포함하여 입력된 경우
         */
        if (input.startsWith("//")) {
            int indexOfEndSign = input.indexOf("\\n"); // 개행문자가 아닌 \n라는 문자를 찾는다
            if (indexOfEndSign == -1) {
                throw new IllegalArgumentException("커스텀 구분자 선언 후 '\\n'이 필요합니다.");
            }
            String customDelimiterPart = input.substring(2, indexOfEndSign);
            delimiter = "[,:]|" + Pattern.quote(customDelimiterPart);
            numberPart = input.substring(indexOfEndSign + 2);
        }

        String[] tokens = numberPart.split(delimiter);
        return add(tokens);
    }

    private static int add(String[] tokens) {
        int result = 0;

        for (String token : tokens) {
            result += Integer.parseInt(token);
        }
        return result;
    }
}
