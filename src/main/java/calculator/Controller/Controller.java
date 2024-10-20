package calculator.Controller;

import calculator.Model.CheckDouble;
import calculator.View.Input;
import calculator.View.Result;

public class Controller {
    Input input = new Input();
    Result result = new Result();

    CheckDouble check = new CheckDouble();

    public void calculator(){
        String userInput = input.userInput();
        result.result(check.checkDecimalPoint(userInput));
    }
}
