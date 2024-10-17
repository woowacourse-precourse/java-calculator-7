package calculator.controller.service;

import calculator.controller.CalculatorController;
import calculator.number.service.PositiveNumberGenerator;
import calculator.service.generator.CreateProcess;
import calculator.service.generator.ExtractProcess;
import calculator.service.calculator.CalculatorProcess;
import calculator.separator.service.SeparatorGenerator;
import calculator.view.input.handler.InputHandlerService;
import calculator.view.input.handler.NumberInputHandler;
import calculator.view.input.service.InputView;
import calculator.view.output.OutputProcess;
import calculator.view.output.ResultService;

public class CalculatorControllerFactory {
    public static CalculatorController create() {
        CalculatorProcess calculatorProcess = new CalculatorProcess();
        InputHandlerService inputHandlerService = new NumberInputHandler(new InputView(new OutputProcess()));
        ResultService resultService = new OutputProcess();
        SeparatorGenerator separatorGenerator = new SeparatorGenerator(new ExtractProcess(), new CreateProcess());
        PositiveNumberGenerator numberGenerator = new PositiveNumberGenerator(new ExtractProcess(), new CreateProcess());
        return new CalculatorController(
                separatorGenerator,
                numberGenerator,
                calculatorProcess,
                inputHandlerService,
                resultService);
    }
}
