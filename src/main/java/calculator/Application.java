package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        // 사용자 입력
        String input = Console.readLine();
        // 덧셈 결과
        int result = add(input);
        // 결과 출력
        System.out.println("결과 : "+ result);
    }

    // 1. 빈 문자열 또는 null 입력 시 0을 반환
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return -1;
    }

    // 2. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 숫자 합을 반환
    // 3. 커스텀 구분자를 지정하여 숫자의 합을 반환
    // 4. 잘못된 입력 시 IllegalArgumentException을 발생

}
