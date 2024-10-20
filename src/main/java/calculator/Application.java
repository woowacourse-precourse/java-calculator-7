package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        /** 기능 1 구현 */
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        /** 기능 2 구현 */
        String inputData = Console.readLine();

        /** 기능 3-1 구현
         * 빈 값의 경우
         */
        if (inputData.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
    }
}