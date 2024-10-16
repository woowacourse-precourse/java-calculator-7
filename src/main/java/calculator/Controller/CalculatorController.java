package calculator.Controller;

import calculator.Model.CalculateModel;
import calculator.View.Input;
import calculator.View.InputImpl;
import calculator.View.Output;
import calculator.View.OutputImpl;

public class CalculatorController {
    public void run() {
        //Input 호출
        Input input = new InputImpl();
        String inputString = input.getStringInput();

        //Model 호출
        CalculateModel calculateModel = new CalculateModel();
        int result = calculateModel.calculate(inputString);

        //Output 호출
        Output output = new OutputImpl();
        output.printResult(result);

    }
}
