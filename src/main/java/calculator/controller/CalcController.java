package calculator.controller;

import calculator.model.CalcModel;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalcController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CalcModel calcModel;

    public CalcController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calcModel = new CalcModel();
    }

    public void run() {
        printStart();
        printResult(getResult(getInput()));
    }

    public String getInput() {
        return inputView.getInputString();
    }

    public int getResult(String inputString) {
        return calcModel.calcResult(inputString);
    }

    public void printStart() {
        outputView.printStart();
    }

    public void printResult(int result) {
        outputView.printResult(result);
    }
}
