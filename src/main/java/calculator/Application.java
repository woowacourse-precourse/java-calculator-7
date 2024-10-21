package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 문자열을 입력받음
        System.out.print("덧셈할 문자열을 입력해 주세요 : ");
        String input = Console.readLine();

        int result = add(input);
        System.out.println("결과: " + result);
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열 또는 null 입력 시 0 반환
        }

        return 0;  // 이후 단계에서 추가 구현 예정
    }
}
