package calculator.presentation;


import calculator.application.TextCalculatorService;
import calculator.application.command.CalculateCommand;
import calculator.presentation.dto.InputData;

public class TextCalculatorController {

    private final TextCalculatorService textCalculatorService;

    public TextCalculatorController(final TextCalculatorService textCalculatorService) {
        this.textCalculatorService = textCalculatorService;
    }

    public Long getSumTotal(final InputData userInput) {

        CalculateCommand command = new CalculateCommand(userInput);
        return textCalculatorService.calculateSumTotal(command);
    }
}
