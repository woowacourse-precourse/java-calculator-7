package calculator.controller;

import calculator.service.generator.controller.GenerateController;
import calculator.number.domain.NumberService;
import calculator.sentence.dto.Sentence;
import calculator.regex.domain.RegexPattern;
import calculator.service.calculator.CalculatorService;
import calculator.regex.service.RegexPatternServiceResolver;
import calculator.view.input.handler.InputHandlerService;
import calculator.view.output.ResultService;

public class CalculatorController {
    private final GenerateController generateController;
    private final InputHandlerService inputProcess;
    private final RegexPatternServiceResolver numberTypeController;

    public CalculatorController(
            GenerateController generateController,
            InputHandlerService inputProcess,
            RegexPatternServiceResolver numberTypeController) {
        this.generateController = generateController;
        this.inputProcess = inputProcess;
        this.numberTypeController = numberTypeController;
    }

    public void run() {
        Sentence sentence = inputProcess.receive(Sentence::new);
        RegexPattern regexPattern = RegexPattern.getRegexPattern(sentence);
        ResultService outputProcess = numberTypeController.getResultService(regexPattern);
        CalculatorService calculatorService = numberTypeController.getCalculatorService(regexPattern);
        NumberService number = generateController.createNumber(
                sentence,
                numberTypeController.getConvertorService(regexPattern),
                numberTypeController.getService(regexPattern));
        Number result = calculatorService.sum(number);
        outputProcess.result(result);
    }
}
