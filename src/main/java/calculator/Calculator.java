package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.part.CalculateComposition;
import calculator.part.CalculatorAdder;
import calculator.separator.AddSeparator;
import calculator.separator.DefaultSeparator;
import calculator.separator.SeparatorStorage;

public class Calculator {
    private static final SeparatorStorage separatorStorage = new SeparatorStorage();
    public void initialize(){
        separatorStorage.addSeparator(":");
        separatorStorage.addSeparator(",");
    }
}
