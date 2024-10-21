package calculator.presentation;


import calculator.business.TextCalculatorService;
import calculator.business.command.CalculateCommand;

public class TextCalculatorController {

    private final TextCalculatorService textCalculatorService;

    public TextCalculatorController(final TextCalculatorService textCalculatorService) {
        this.textCalculatorService = textCalculatorService;
    }

    public Long getSumTotal(final InputData userInput) {

        CalculateCommand calculateCommand = new CalculateCommand(userInput);
        return textCalculatorService.calculateSumTotal(calculateCommand);
    }
}
