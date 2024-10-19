package calculator.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {};

    public static String inputString() {
        System.out.print(ViewMessage.INPUT_STRING);
        String input = Console.readLine();
        return input;
    }
}
