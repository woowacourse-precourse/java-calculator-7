package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 프로그램 시작
        try {
            playGame();
        } catch (IllegalArgumentException e) {
            System.out.println("애플리케이션을 종료합니다.");
        }
    }

    private static void playGame() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 큰따옴표, 작은따옴표, 백틱 제거
        input = input.replace("\"", "")
                .replace("'", "")
                .replace("`", "");

        input = input.replace("\\n", "\n");

        int result = addNumbers(input);
        System.out.println("결과 : " + result);
    }

    public static int addNumbers(String input) {
        // 빈 문자열이나 공백 문자열인 경우 0을 반환
        if (input.trim().isEmpty()) {
            return 0;
        }

        // 기본 구분자 설정
        String delimiter = ",|:";

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            // 커스텀 구분자를 설정
            delimiter = input.substring(2, delimiterEndIndex).trim();
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] tokens = input.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            int number = parseNumber(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수 값은 허용되지 않습니다.");
            }
            sum += number;
        }

        return sum;
    }

    private static int parseNumber(String token) {
        if (token.trim().isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(token.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
