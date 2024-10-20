package calculator.controller.service;

import calculator.controller.CalculatorController;
import calculator.service.generator.controller.GenerateController;
import calculator.service.generator.number.NumberGenerator;
import calculator.service.generator.number.impl.NumberCreateProcess;
import calculator.service.generator.number.impl.NumberExtractProcess;
import calculator.regex.service.RegexPatternServiceResolver;
import calculator.view.input.handler.InputHandlerService;
import calculator.view.input.handler.impl.NumberInputHandler;
import calculator.view.input.service.impl.InputView;
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
