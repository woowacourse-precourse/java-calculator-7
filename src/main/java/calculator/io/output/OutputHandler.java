package calculator.io.output;

import calculator.CalculatorException;

public interface OutputHandler {

    void showUserInputMessage();

    void showAdditionResult(int calculateResult);

    void showExceptionMessage(CalculatorException e);

    void showExceptionMessage(String message);

}
