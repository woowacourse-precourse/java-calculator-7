package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자 입력 받기
        try {
            int result = add(input);  // 입력값을 계산
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }

    // 문자열을 받아서 숫자를 더한 결과를 반환하는 함수
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열이거나 null인 경우 0 반환
        }

        String[] numbers = split(input);  // 구분자를 기준으로 문자열 분리
        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {  // 숫자가 비어있지 않을 때만 처리
                int num = toPositiveInt(number);  // 문자열을 정수로 변환
                sum += num;
            }
        }
        return sum;
    }

    // 커스텀 구분자 및 기본 구분자에 따라 문자열을 분리하는 함수
    private static String[] split(String input) {
        String delimiter = ",|:";  // 기본 구분자: 쉼표와 콜론

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 올바르지 않습니다.");
            }
            // 커스텀 구분자 추출
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);  // 구분자 이후의 숫자들만 남김
        }

        return input.split(delimiter);  // 기본 및 커스텀 구분자에 따라 분리
    }

    // 숫자 문자열을 정수로 변환하고 양수만 허용
    private static int toPositiveInt(String number) {
        try {
            int num = Integer.parseInt(number);  // 문자열을 숫자로 변환
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
