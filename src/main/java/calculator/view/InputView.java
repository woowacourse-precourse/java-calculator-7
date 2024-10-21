package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView inputView;
    public static InputView getInstance(){
        if (inputView == null){
            inputView = new InputView();
        }
        return inputView;
    }
    public String readLine(){
        return Console.readLine();
    }
}
