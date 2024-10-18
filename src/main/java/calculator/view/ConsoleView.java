package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    public String askAdditionFormulaString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void tellResult(String result) {
        System.out.printf("결과 : %s\n", result);
    }

}
