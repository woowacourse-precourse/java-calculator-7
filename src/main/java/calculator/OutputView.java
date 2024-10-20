package calculator;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    public void displayResult(int result) {
        System.out.println("결과 : " + result);
        Console.close();
    }
}
