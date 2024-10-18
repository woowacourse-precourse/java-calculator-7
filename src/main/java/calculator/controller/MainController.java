package calculator.controller;

import calculator.model.domain.Calculator;
import calculator.model.domain.Separator;
import calculator.model.dto.ResultDto;
import calculator.view.InputView;
import calculator.view.OutputView;

public class MainController {
    public void start() {
        String inputString = InputView.inputString();
        String processedInputString = Separator.separatorGenerator(inputString);
        ResultDto resultDto = Calculator.calculate(processedInputString);
        OutputView.outputResult(resultDto);

    }
}
