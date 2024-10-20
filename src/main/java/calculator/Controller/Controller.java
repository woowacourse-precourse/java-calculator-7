package calculator.Controller;

import calculator.Model.Calculate;
import calculator.View.Input;
import calculator.View.Result;

public class Controller {
    Input input = new Input();
    Result result = new Result();
    Calculate calc = new Calculate();

    public void calculator(){
        String userInput = input.userInput();
        result.result(calc.plusNum(userInput));
    }
}
