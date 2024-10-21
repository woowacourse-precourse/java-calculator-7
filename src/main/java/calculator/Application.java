package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Calculate calculator = new Calculate();

        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        System.out.println("결과 : "+ calculator.inputString(readLine()));
    }
}
