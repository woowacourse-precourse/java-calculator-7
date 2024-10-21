package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = calculate(input);  // 계산 실행
            System.out.println("결과 : " + result);  // 결과 출력
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());  // 잘못된 입력 처리
        }
    }

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열은 0으로 처리
        }

        String delimiter = ",|:";  // 기본 구분자 쉼표와 콜론
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            delimiter = input.substring(2, delimiterEndIndex);  // 커스텀 구분자 추출
            numbers = input.substring(delimiterEndIndex + 1);   // 숫자 부분 추출
        }

        String[] tokens = numbers.split(delimiter);  // 구분자로 문자열 분리
        int sum = 0;
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token.trim());  // 숫자 변환 시도
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");  // 예외 처리
            }
        }

        return sum;
    }
}
