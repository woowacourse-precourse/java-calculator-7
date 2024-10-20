package calculator;

import calculator.calculate.Calculate;
import calculator.calculate.ParsingString;
import calculator.exception.Exception;
import calculator.global.GlobalConstant;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        GlobalConstant.StartIndex = 0;
        ArrayList<Integer> numlist;
        InputView input_view = new InputView();
        OutputView output_view = new OutputView();
        String input = input_view.getInput();
        Exception.IsEmptyInput(input);
        ParsingString check_delemeter = new ParsingString(input);
        check_delemeter.AddDelemeter();
        numlist = check_delemeter.MakeNumList();
        int result = Calculate.Makesum(numlist);
        output_view.output(result);
    }
}
