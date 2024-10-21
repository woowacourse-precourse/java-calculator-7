package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        //str값을 input 받는다.
        String input = Console.readLine();
        //Array or List를 활용해서 더하기 후 결과값 출력
        System.out.println("결과 : " + new Calculator(input).convertStringToIntArrayAndSum());
    }
}
