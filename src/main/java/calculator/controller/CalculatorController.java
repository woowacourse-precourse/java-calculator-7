package calculator.controller;

import calculator.generator.controller.GenerateController;
import calculator.number.domain.Number;
import calculator.sentence.domain.Sentence;
import calculator.service.CalculatorProcess;
import calculator.view.input.handler.InputHandlerService;
import calculator.view.output.ResultService;

public class CalculatorController {
    private final GenerateController generateController;
    private final InputHandlerService inputProcess;
    private final ResultService outputProcess;
    public CalculatorController(
            GenerateController generateController,
            InputHandlerService inputProcess,
            ResultService outputProcess) {
        this.generateController = generateController;
        this.inputProcess = inputProcess;
        this.outputProcess = outputProcess;
    }
    public void run() {
        Sentence sentence = inputProcess.receive(Sentence::new);
        Number number =  generateController.createNumber(sentence);
        long result = CalculatorProcess.sum(number);
        outputProcess.result(result);
    }
}
