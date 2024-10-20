package calculator.controller;

import calculator.service.generator.controller.GenerateController;
import calculator.number.domain.NumberService;
import calculator.sentence.dto.Sentence;
import calculator.regex.domain.RegexPattern;
import calculator.service.calculator.CalculatorService;
import calculator.regex.service.RegexServiceRegistry;
import calculator.view.input.handler.InputHandlerService;
import calculator.view.output.ResultService;

public class CalculatorController {
    private final GenerateController generateController;
    private final InputHandlerService inputProcess;
    private final RegexServiceRegistry regexServiceRegistry;

    public CalculatorController(
            GenerateController generateController,
            InputHandlerService inputProcess,
            RegexServiceRegistry regexServiceRegistry) {
        this.generateController = generateController;
        this.inputProcess = inputProcess;
        this.regexServiceRegistry = regexServiceRegistry;
    }

    public void run() {
        Sentence sentence = inputProcess.receive(Sentence::new);
        RegexPattern regexPattern = RegexPattern.getRegexPattern(sentence);
        ResultService outputProcess = regexServiceRegistry.getResultService(regexPattern);
        CalculatorService calculatorService = regexServiceRegistry.getCalculatorService(regexPattern);
        NumberService number = generateController.createNumber(
                sentence,
                regexServiceRegistry.getConvertorService(regexPattern),
                regexServiceRegistry.getService(regexPattern));
        Number result = calculatorService.sum(number);
        outputProcess.result(result);
    }
}
