package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    public String askCalculationFormula() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputCalculationFormula = Console.readLine();
        return inputCalculationFormula;
    }

    public void showResult(String result) {
        System.out.printf("결과 : %s\n", result);
    }

}
