package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int sum = 0;
        char custom = ',';

        // 빈 문자열을 받는 경우 0 출력
        if (input == "") {
            System.out.println("결과 : " + sum);
            return;
        }

        try {
            // 커스텀 구분자 지정
            if (input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
                custom = input.charAt(2);
                if (custom >= '0' && custom <= '9') {
                    throw new IllegalArgumentException("숫자 커스텀 구분자 예외 발생");
                }
                input = input.substring(5);
            }

            // 구분자를 기준으로 숫자 추출
            // 여러 개의 구분자를 표현하기 위해 정규식 사용
            String[] nums = input.split(String.format(",|:|%c", custom));

            for (String num : nums) {
                if (Integer.parseInt(num) < 0) {
                    throw new IllegalArgumentException("음수 예외 발생");
                }
                sum += Integer.parseInt(num);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        System.out.println("결과 : " + sum);

        Console.close();
    }
}
