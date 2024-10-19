package calculator.io.output;

import calculator.CalculatorException;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showUserInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    @Override
    public void showAdditionResult(int calculateResult) {
        System.out.println("결과 : " + calculateResult);
    }

    @Override
    public void showExceptionMessage(CalculatorException e) {
        throw new IllegalArgumentException(e.getMessage());
    }

    @Override
    public void showExceptionMessage(String message) {
        throw new IllegalArgumentException(message);
    }

}