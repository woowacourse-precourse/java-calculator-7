package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.part.CalculateComposition;
import calculator.part.CalculatorAdder;
import calculator.separator.AddSeparator;
import calculator.separator.DefaultSeparator;
import calculator.separator.SeparatorStorage;
import java.math.BigInteger;

public class Calculator {

    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    private final DefaultSeparator defaultSeparator = new DefaultSeparator();
    private final CalculatorAdder calculatorAdder = new CalculatorAdder();
    private final CalculateComposition calculateComposition = new CalculateComposition(calculatorAdder);
    private static final SeparatorStorage separatorStorage = new SeparatorStorage();

    public void initialize(){

        separatorStorage.addSeparator(":");
        separatorStorage.addSeparator(",");

    }
    public void run(){
        consoleOutputHandler.showInputComments();
        String userInput = consoleInputHandler.getUserInput();

        if (IsUserInputEmptyString(userInput)) {
            consoleOutputHandler.showFinalOutput(BigInteger.ZERO);
            return;
        }

        String parsedInput = AddSeparator.addCustomSeparator(userInput);

        BigInteger[] toSumArrays = defaultSeparator.separateStringToSum(parsedInput,separatorStorage);

        BigInteger sum = calculateComposition.makeSum(toSumArrays);

        consoleOutputHandler.showFinalOutput(sum);
    }

    private static boolean IsUserInputEmptyString(String userInput) {
        return userInput.trim().isEmpty();
    }
}
