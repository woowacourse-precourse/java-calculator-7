package calculator.controller.service;

import calculator.controller.CalculatorController;
import calculator.generator.controller.GenerateController;
import calculator.generator.number.NumberGenerator;
import calculator.generator.number.impl.NumberCreateProcess;
import calculator.generator.number.impl.NumberExtractProcess;
import calculator.regex.service.RegexPatternServiceResolver;
import calculator.view.input.handler.InputHandlerService;
import calculator.view.input.handler.NumberInputHandler;
import calculator.view.input.service.InputView;
import calculator.view.output.impl.LongOutputProcess;

public class CalculatorControllerFactory {
    public static CalculatorController create() {
        InputHandlerService inputHandlerService = new NumberInputHandler(new InputView(new LongOutputProcess()));
        NumberGenerator numberGenerator = new NumberGenerator(new NumberExtractProcess(), new NumberCreateProcess());
        GenerateController generateController = new GenerateController(numberGenerator);
        RegexPatternServiceResolver numberTypeController = new RegexPatternServiceResolver();
        return new CalculatorController(
                generateController,
                inputHandlerService,
                numberTypeController);
    }
}
