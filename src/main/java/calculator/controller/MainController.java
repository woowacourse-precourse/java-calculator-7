package calculator.controller;

import calculator.dto.AddCalculatorRequest;
import calculator.dto.AddCalculatorResponse;
import calculator.view.UserInputView;
import calculator.view.UserOutputView;

public class MainController {

    private final CalculatorController calculatorController = new CalculatorController();

    public void start(){
        UserOutputView.printAddStartMessage();
        String userInput = UserInputView.readUserInput();
        AddCalculatorResponse response = calculatorController.addCalculator(new AddCalculatorRequest(userInput));
        UserOutputView.printAddResultMessage(response);
    }
}
