package calculator;

import camp.nextstep.edu.missionutils.Console;

public class MainProgram {

    private final Calculator calculator;

    public MainProgram(Calculator calculator) {
        this.calculator = calculator;
    }

    public void mainEntry() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        int sum = calculator.sum(str);
        System.out.println("결과 : " + sum);
    }
}
