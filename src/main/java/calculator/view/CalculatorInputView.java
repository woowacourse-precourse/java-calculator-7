package calculator.view;

import calculator.model.AdditionInput;
import calculator.util.CalculatorInputValidator;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorInputView {
    CalculatorInputValidator calculatorInputValidator = new CalculatorInputValidator();
    public AdditionInput getAdditionString(){
        AdditionInput additionInput = new AdditionInput(Console.readLine());
        return additionInput;
    }
}
