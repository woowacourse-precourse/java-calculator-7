package calculator.controller;

import calculator.model.CalculatorService;
import calculator.model.CalculatorServiceImpl;
import calculator.model.StringService;
import calculator.model.StringServiceImpl;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
    InputView inputView = new CalculatorInput();
    StringService stringService = new StringServiceImpl();
    CalculatorService calculatorService = new CalculatorServiceImpl();
    OutputView outputView = new CalculatorOutput();

    public void calculate() {
        String inputString = inputView.input();

        /* Controller가 실행 흐름 담당 */
        List<Integer> integerList = stringService.toIntegerList(stringService.parse(inputString));
        Integer result = calculatorService.sum(integerList);

        outputView.printResult(result);
    }
}
