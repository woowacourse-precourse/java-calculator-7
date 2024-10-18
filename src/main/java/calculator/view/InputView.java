package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import static calculator.view.ViewMessage.INPUT_MESSAGE;

public class InputView {
    public static String inputExpression() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}