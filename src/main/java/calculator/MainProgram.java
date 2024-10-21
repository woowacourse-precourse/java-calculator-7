package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자의 입력을 받아 계산 결과를 출력하는 클래스입니다.
 */
public class MainProgram {

    private final Calculator calculator;

    public MainProgram(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * 프로그램의 메인 로직을 실행합니다. 사용자로부터 문자열을 입력받아 계산 결과를 출력합니다.
     */
    public void mainEntry() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        int sum = calculator.sum(str);
        System.out.println("결과 : " + sum);
    }
}
