package calculator;

import calculator.controller.CalculateIntegerList;
import calculator.controller.ParsingInputString;
import calculator.model.InputString;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputString inputString = new InputString(InputView.input());
        ParsingInputString parsingInputString = new ParsingInputString(inputString);
        CalculateIntegerList calculateIntegerList = new CalculateIntegerList(inputString);

        parsingInputString.findCustomChar();
        parsingInputString.parsingInput();

        OutputView.printResult(calculateIntegerList.calculate());
    }
}
