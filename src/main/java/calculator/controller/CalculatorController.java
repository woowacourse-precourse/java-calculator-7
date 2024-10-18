package calculator.controller;

import calculator.generator.controller.GenerateController;
import calculator.number.domain.Number;
import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;
import calculator.service.CalculatorProcess;
import calculator.view.input.handler.InputHandlerService;
import calculator.view.output.ResultService;

public class CalculatorController {
    private final GenerateController generateController;
    private final InputHandlerService inputHandlerService;
    private final ResultService resultService;
    public CalculatorController(
            GenerateController generateController,
                                InputHandlerService inputHandlerService,
                                ResultService resultService) {
        this.generateController = generateController;
        this.inputHandlerService = inputHandlerService;
        this.resultService = resultService;
    }
    public void run() {
        Sentence sentence = inputHandlerService.receive(Sentence::new);
        Separator separator = generateController.createSeparator(sentence);
        Number number =  generateController.createNumber(sentence, separator);
        long result = CalculatorProcess.sum(number);
        resultService.result(result);
    }
}
