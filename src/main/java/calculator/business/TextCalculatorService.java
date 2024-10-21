package calculator.business;

import calculator.business.command.CalculateCommand;

public interface TextCalculatorService {

    Long calculateSumTotal(CalculateCommand calculateCommand);
}
