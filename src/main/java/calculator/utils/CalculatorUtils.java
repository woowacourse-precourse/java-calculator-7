package calculator.utils;

import calculator.Adder;
import calculator.CustomDelimiterPresenceChecker;
import calculator.NumberInputPrompter;
import calculator.OutputPrinter;

public class CalculatorUtils {
    private final NumberInputPrompter numberInputPrompter = new NumberInputPrompter();
    private final CustomDelimiterPresenceChecker customDelimiterPresenceChecker = new CustomDelimiterPresenceChecker();
    private final Adder adder = new Adder();
    private final OutputPrinter outputPrinter = new OutputPrinter();


    public String requestNumber() {
        return numberInputPrompter.numberInputReceive();
    }

    public int addNumber(String[] seperatedNumbers) {
        return adder.add(seperatedNumbers);
    }

    public void printResult(int sum) {
        outputPrinter.printResult(sum);
    }

}
