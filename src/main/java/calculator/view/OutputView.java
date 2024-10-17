package calculator.view;

import static calculator.view.constants.ViewMessage.OUTPUT_VIEW_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    public void print(long sumResult) {
        String outputViewMessage = String.format(OUTPUT_VIEW_MESSAGE.getMessage(), sumResult);
        System.out.println(outputViewMessage);
        Console.close();
    }
}
