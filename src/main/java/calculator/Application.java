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

        /** 기능 3-2 구현 */
        String basicDelimiter = ",|:";

        int sum = 0;

        /** 기능 3-3 구현
         * 커스텀 구분자의 경우
         */
        if (inputData.startsWith("//") && (inputData.contains("\\n"))) {
            /** "\n" 문자열의 시작 위치를 index 변수에 저장 */
            int index = inputData.indexOf("\\n");

            /** 커스텀 구분자 초기화 */
            String customDelimiter = inputData.substring(2, index);
        }
    }
}