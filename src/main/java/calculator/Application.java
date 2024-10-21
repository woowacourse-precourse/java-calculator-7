package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int calculator_7(String str){
        if (str.trim().isEmpty()) return 0;

        return 0;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculator_7(input);
        System.out.println("결과 : " + result);
    }
}
