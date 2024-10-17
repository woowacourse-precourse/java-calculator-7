package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    public void print(long sumResult) {
        System.out.println("결과 : " + sumResult);
        Console.close();
    }
}
