package calculator.controller;

import calculator.number.domain.Number;
import calculator.number.service.PositiveNumberGenerator;
import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;
import calculator.service.calculator.CalculatorProcess;
import calculator.separator.service.SeparatorGenerator;
import calculator.view.input.handler.InputHandlerService;
import calculator.view.output.ResultService;

public class CalculatorController {
    private final SeparatorGenerator separatorGenerator;
    private final PositiveNumberGenerator positiveNumberGenerator;
    private final CalculatorProcess calculatorProcess;
    private final InputHandlerService inputHandlerService;
    private final ResultService resultService;
    public CalculatorController(
            SeparatorGenerator separatorGenerator,
            PositiveNumberGenerator positiveNumberGenerator,
            CalculatorProcess calculatorProcess,
                                InputHandlerService inputHandlerService,
                                ResultService resultService) {
        this.separatorGenerator = separatorGenerator;
        this.positiveNumberGenerator = positiveNumberGenerator;
        this.calculatorProcess = calculatorProcess;
        this.inputHandlerService = inputHandlerService;
        this.resultService = resultService;
    }
    public void run() {
        Sentence sentence = inputHandlerService.receive(Sentence::new);
        Separator separator = separatorGenerator.create(sentence);
        Number positiveNumber =  positiveNumberGenerator.create(sentence, separator);
        long result = calculatorProcess.sum(positiveNumber);
        resultService.result(result);
    }
}
