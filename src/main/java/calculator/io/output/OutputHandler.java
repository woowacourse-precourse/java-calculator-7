package calculator.io.output;

import calculator.CalculatorException;

public interface OutputHandler {

    void showUserInputMessage();

    void showAdditionResult(long calculateResult);

    void showExceptionMessage(CalculatorException e);

    void showExceptionMessage(String message);

}
