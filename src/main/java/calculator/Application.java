package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int add(String input) {
        // 입력이 null 이거나 빈 문자열일 경우 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String defaultSeparator = ",|:";  // 기본 구분자 쉼표(,)와 콜론(:)
        String numbers = input;

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            // 커스텀 구분자와 숫자를 분류
            int defaultIndex = input.indexOf("\\n");
            if (defaultIndex == -1) {
                throw new IllegalArgumentException(" 커스텀 구분자가 잘못된 형식입니다.");
            }
            // 커스텀 구분자를 추출하여 기본 구분자로 설정
            String customSeparator = input.substring(2, defaultIndex);
            defaultSeparator = customSeparator; // 커스텀 구분자 설정
            numbers = input.substring(defaultIndex + 2);    // 숫자 문자열 추출
        }

        // 구분자를 기준으로 문자열 분리
        String[] tokens = numbers.split(defaultSeparator);

        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    int number = toPositiveInt(token);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(e.getMessage());
                }
            }
        }
        return sum;
    }


    // 숫자 문자열을 양의 정수로 변환, 음수인 경우 예외 발생
    private static int toPositiveInt(String token) {
        int number = Integer.parseInt(token.trim());
        if (number < 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류" + e.getMessage());
        }
    }
}
