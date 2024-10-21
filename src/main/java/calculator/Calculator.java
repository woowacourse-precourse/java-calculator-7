package calculator;

public class Calculator {

    public void calculate() throws IllegalArgumentException{

        ConsoleOutputHandler.showStartComment();

        String userInput = ConsoleInputHandler.getUserInput();

        int[] operands = InputSplitter.split(userInput);

        int sum = 0;

        for(int operand : operands)
            sum += operand;

        ConsoleOutputHandler.showResult(sum);
    }
}
