package calculator;

public class CalculatorFlow {
    public void start() {
        UserInput.showInputPrompt();
        String inputValue = UserInput.receiveInput();

        int[] extractedNumbers = NumberExtractor.extractNumbers(inputValue);

        OperationExecutor sumOperation = new OperationExecutor();
        int result = sumOperation.calculate(extractedNumbers);

        System.out.println("결과 : " + result);
    }
}
