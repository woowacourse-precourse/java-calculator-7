package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public void print(int sum) {
        System.out.println(RESULT_MESSAGE + sum);
        Console.close();
    }
}
