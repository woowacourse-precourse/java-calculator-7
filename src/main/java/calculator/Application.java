package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);  // 디버깅용 입력값 출력
        try {
            int result = calculateSum(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 예외 메시지를 출력하고 애플리케이션 종료
            System.err.println(e.getMessage());
            throw e;  // 예외를 다시 던져서 테스트가 예외를 감지할 수 있도록 처리
        }
    }

    public static int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 기본 구분자 설정
        String delimiter = ",|:";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);  // 커스텀 구분자 추출
                input = input.substring(delimiterIndex + 2);  // \\n 이후의 문자열 추출
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        // 입력이 비어있을 경우 0 반환
        if (input.isEmpty()) {
            return 0;
        }

        // 구분자로 문자열을 나누고 합 계산
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            if (number.trim().isEmpty()) {
                continue;
            }
            try {
                int parsedNumber = Integer.parseInt(number.trim());
                if (parsedNumber < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                }
                sum += parsedNumber;
            } catch (NumberFormatException e) {
                // 유효하지 않은 숫자 형식일 경우 예외 발생
                throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
            }
        }

        return sum;
    }
}