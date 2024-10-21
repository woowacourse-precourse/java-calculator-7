package calculator;

import static calculator.Calculator.addNumbers;
import static calculator.ConsoleIO.printOutput;
import static calculator.ConsoleIO.readInput;
import static calculator.Extractor.extractNumbers;
import static calculator.Separator.getSeparator;

public class Executor {

    public static void executeCalculator() {
        String inputStr = readInput();

        String separators = getSeparator(inputStr);
        String numbers = extractNumbers(inputStr);

        long answer = addNumbers(numbers, separators);

        printOutput(answer);
    }

}
