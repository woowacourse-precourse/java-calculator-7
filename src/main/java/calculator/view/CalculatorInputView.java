package calculator.view;

import calculator.model.AdditionCommand;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorInputView {
    public AdditionCommand getAdditionCommand(){
        AdditionCommand additionCommand = new AdditionCommand(Console.readLine());
        return additionCommand;
    }
}
