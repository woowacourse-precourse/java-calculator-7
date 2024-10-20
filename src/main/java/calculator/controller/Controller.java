package calculator.controller;

import calculator.model.Operand;
import calculator.model.Result;
import calculator.model.WoowahanTokenizer;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    public static void run() {
        String inputString = InputView.readLine();
        WoowahanTokenizer wt = new WoowahanTokenizer(inputString);
        Operand operand = new Operand(wt.getStringTokens());
        Result result = new Result(operand.getNumbers());
        OutputView.printResult(result.getValue());
    }
}
