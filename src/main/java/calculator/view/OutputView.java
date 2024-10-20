package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    public void showResult(int result) {
        Console.close();
        System.out.println("결과 : " + result);
    }
}
