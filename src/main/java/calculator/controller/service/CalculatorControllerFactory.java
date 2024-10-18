package calculator.controller.service;

import calculator.controller.CalculatorController;
import calculator.generator.controller.GenerateController;
import calculator.generator.number.NumberGenerator;
import calculator.generator.number.impl.NumberCreateProcess;
import calculator.generator.number.impl.NumberExtractProcess;
import calculator.generator.separator.impl.SeparatorCreateProcess;
import calculator.generator.separator.impl.SeparatorExtractProcess;
import calculator.generator.separator.SeparatorGenerator;
import calculator.view.input.handler.InputHandlerService;
import calculator.view.input.handler.NumberInputHandler;
import calculator.view.input.service.InputView;
import calculator.view.output.OutputProcess;
import calculator.view.output.ResultService;

public class CalculatorControllerFactory {
    public static CalculatorController create() {
        InputHandlerService inputHandlerService = new NumberInputHandler(new InputView(new OutputProcess()));
        ResultService resultService = new OutputProcess();
        SeparatorGenerator separatorGenerator = new SeparatorGenerator(new SeparatorExtractProcess(), new SeparatorCreateProcess());
        NumberGenerator numberGenerator = new NumberGenerator(new NumberExtractProcess(), new NumberCreateProcess());
        GenerateController generateController = new GenerateController(separatorGenerator, numberGenerator);
        return new CalculatorController(
                generateController,
                inputHandlerService,
                resultService);
    }
}
