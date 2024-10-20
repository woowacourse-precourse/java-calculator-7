package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = getInput();
        int sum = calculateSum(input);
        System.out.println("결과: " + sum);
    }

    // 입력 처리
    private static String getInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요. : ");
        return Console.readLine();
    }

}