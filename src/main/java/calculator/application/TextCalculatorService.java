package calculator.application;

import calculator.application.command.CalculateCommand;

public interface TextCalculatorService {

    Long calculateSumTotal(CalculateCommand calculateCommand);
}
