package calculator.domain;

import calculator.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final InputView inputView;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public int calculateNumber(){
        inputView.inputSentence();
        int num = 0;
        String input = Console.readLine();
        if(input.equals("")) return 0;

        return num;
    }

}
