package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int sum = 0;
        boolean customized = false;
        char custom = ',';

        // 커스텀 구분자 지정
        if (input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            customized = true;
            custom = input.charAt(2);
            input = input.substring(5);
        }

        // 구분자를 기준으로 숫자 추출
        // 여러 개의 구분자를 표현하기 위해 정규식 사용
        String[] nums = input.split(",|:");

        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        System.out.println("결과 : " + sum);

        Console.close();
    }
}
