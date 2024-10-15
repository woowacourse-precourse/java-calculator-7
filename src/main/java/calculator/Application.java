package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // Get input
        String input = readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }

    private static int add(String input) {
        // 비어있을 경우 0을 반환하자 (3.1 예외)
        if (input.isEmpty()) {
            return 0;
        }
        // 1-1. 기본 구분자만 입력된 경우
        String delimiter = ",|:";

        /**
         * 1.2 커스텀 구분자를 포함하여 입력된 경우
         */
        if (input.startsWith("//")) {
            int indexOfEndSign = input.indexOf("\\");
            if (input.charAt(indexOfEndSign + 1) != 'n') { // \n이 아닌 단순히 \을 구분자로 하고자하는 경우
                delimiter += "|\\\\"; // Escape 문자 처리
            }
            char customDelimiter = input.charAt(indexOfEndSign);
            delimiter += "|" + customDelimiter;
        }

        String[] tokens = input.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
