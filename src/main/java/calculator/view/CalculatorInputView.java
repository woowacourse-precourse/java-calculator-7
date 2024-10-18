package calculator.view;

import calculator.model.AdditionInput;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorInputView {
    public AdditionInput getAdditionString(){
        AdditionInput additionInput = new AdditionInput(Console.readLine());
        return additionInput;
    }
}
