package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        try {
            int result = processInput(inputString);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 프로그램을 종료
            return;
        }
    }

    public static int processInput(String input) {
        // 1-1) 입력된 문자열이 null이거나 빈 문자열인 경우 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // 이후 다른 처리 구현

        return -1; // 임시 반환값
    }
}
