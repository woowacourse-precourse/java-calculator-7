package calculator;

import java.util.List;

public class CalculatorManager {
    private String userInput;
    private String parsedUserInput;
    private List<Character> delimiter;
    private int sum;

    public void makeUserInput(InputHandler inputHandler){
        this.userInput = inputHandler.getUserIntput();
    }

    public void makeDelimiter(DelimiterParser delimiterParser){
        this.delimiter = delimiterParser.parseDelimiter(userInput);
    }

    public void parseMarker(DelimiterParser delimiterParser){
        this.parsedUserInput = delimiterParser.parseMarker(userInput);
    }

    public void checkCompatibility(CheckCompatibility checkCompatibility){
        checkCompatibility.checkInvalidInput(parsedUserInput, delimiter);
    }

    public void calculateSum(Calculator calculator){
        this.sum = calculator.getSum(parsedUserInput,delimiter);
    }

    public void printAnswer(OutputHandler outputHandler){
        outputHandler.printAnswer(sum);
    }
}
