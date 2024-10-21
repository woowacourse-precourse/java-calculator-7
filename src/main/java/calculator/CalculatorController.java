package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Calculator calculator = new Calculator();
    Validator validator = new Validator();

    String userInput;

    public void displayInputView() {
        inputView.printInput();
    }

    public void getUserInput() {
        this.userInput = Console.readLine();
    }

    public boolean calculate() {
/*        try {
            validator.isPositive();
            validator.isValidDelimiter();
            validator.isValidCustomDelimiter();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }*/

        calculator.separateArr(userInput);
        calculator.addArr(userInput);

        return true;
    }

    public void displayOutputView() {
        outputView.printSum(calculator.getSum());
    }
}
