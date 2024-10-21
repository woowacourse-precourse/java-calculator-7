package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        try {
            // 문자열 입력 받기
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            if (input == null || input.isEmpty()) {
                System.out.println("결과 : 0");
                return;
            }

            String delimiter = ",|:";

            // 커스텀 구분자 확인
            if (input.startsWith("//")) {
                int delimiterIndex = input.indexOf("\n");

                // 예외 처리: delimiterIndex 가 -1일 경우 처리
                if (delimiterIndex == -1) {
                    throw new IllegalArgumentException("구분자를 찾을 수 없습니다.");
                }

                delimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex + 1);
            }

            // 입력 문자열을 구분자로 분리
            String[] numbers = input.split(delimiter);
            int sum = 0;

            // 숫자 더하기 및 예외 처리
            for (String number : numbers) {
                int num = Integer.parseInt(number.trim());  // 앞뒤 공백 제거 후 숫자로 변환

                // 음수일 경우 예외 발생
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다. " + num);
                }

                sum += num;
            }

            // 결과 출력
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;  // test 에서 확인 가능
        }
    }
}
