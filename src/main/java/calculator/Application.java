package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 문자열 분리
        String input = Console.readLine();
        int sum = 0;
        String delimiter = ",|:";

        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        if(input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n"); // \n 없으면 -1 출력됨
            if(delimiterIndex != -1) {
                // 커스텀 구분자
                delimiter = input.substring(2, delimiterIndex);
                // 커스텀 구분자 이후 숫자 문자열
                input = input.substring(delimiterIndex + 1);
            }
        }

        String[] inputNumbers = input.split(delimiter);

        System.out.println("결과 : " + sum);
    }
}
