package calculator.controller;

import calculator.model.CalculatorService;
import calculator.model.StringService;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    InputView inputView;
    OutputView outputView;
    CalculatorService calculatorService;
    StringService stringService;

    public CalculatorController(InputView inputView, OutputView outputView, CalculatorService calculatorService,
                                StringService stringService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
        this.stringService = stringService;
    }

    public void calculate() {
        String inputString = inputView.input();

        /* Controller가 실행 흐름 담당 */
        List<Integer> integerList = stringService.toIntegerList(stringService.parse(inputString));
        Integer result = calculatorService.sum(integerList);

        outputView.printResult(result);
    }
}
