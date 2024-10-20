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
        StringBuilder sb = new StringBuilder(OUTPUT_MESSAGE);

        if(input.isBlank()){
            System.out.println(sb.append(0));
            return;
        }

        int result = calculatorController.run(input);
        System.out.println(sb.append(result));
    }
}
