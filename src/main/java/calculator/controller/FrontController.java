package calculator.controller;

import calculator.domain.InputtedString;
import calculator.domain.NumericSequence;
import calculator.domain.Result;
import calculator.domain.delimiters.Delimiters;
import calculator.domain.delimiters.DelimitersFactory;
import calculator.view.ConsoleInputView;
import calculator.view.ConsoleOutputView;
import calculator.view.InputView;
import calculator.view.OutputView;

public class FrontController {
    public static void run() {

        InputView inputView = new ConsoleInputView();
        InputtedString inputtedString = new InputtedString(inputView.getNextLine());
        DelimitersFactory factory = new DelimitersFactory();
        Delimiters delimiters = factory.getFromStringAfterValidate(inputtedString);
        NumericSequence numericSequence =
                NumericSequence.getOfStringAndDelimiters(inputtedString, delimiters);
        OutputView outputView = new ConsoleOutputView();
        outputView.printResult(new Result(numericSequence));
    }
}
