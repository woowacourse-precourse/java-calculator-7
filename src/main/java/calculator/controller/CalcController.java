package calculator.controller;

import calculator.service.CalcService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalcController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CalcService calcService = new CalcService();

    public void run() {
        String input = inputView.readInputString();
        String[] numbers = calcService.getNumbers(input);
        calcService.addNumberToList(numbers);
        int result = calcService.getResult();
        outputView.printResult(result);
    }
}
