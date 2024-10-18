package calculator.common.io;

import camp.nextstep.edu.missionutils.Console;

public class OutputHandler {

    private static final String MESSAGE = "결과 : ";

    public void printSumResult(int result) {
        System.out.println(MESSAGE + result);
        Console.close();
    }
}
