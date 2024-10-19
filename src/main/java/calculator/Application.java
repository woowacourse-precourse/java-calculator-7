package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    // "덧셈할 문자열을 입력해주세요." 구문 출력
    private static void init_print() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    // ``Console.readLine()`` 함수를 이용하여 구분자와 양수로 구분된 문자열 입력받기
    private static String input() {
        return Console.readLine();
    }

    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init_print();
        String str = input();
    }
}
