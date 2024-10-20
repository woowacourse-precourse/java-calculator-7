package calculator.view;

import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

import static calculator.view.ViewMessages.INPUT_MESSAGE;
import static calculator.view.ViewMessages.OUTPUT_MESSAGE;

public class UserView {
    private final CalculatorController calculatorController;

    public UserView(CalculatorController calculatorController){
        this.calculatorController = calculatorController;
    }

    public void run(){
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();

        int result = calculatorController.run(input);
        StringBuilder sb = new StringBuilder(OUTPUT_MESSAGE);
        System.out.println(sb.append(result));
    }
}
