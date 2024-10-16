package calculator;

import calculator.calculator.AddNumCalculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        AddNumCalculator addNumCalculator = new AddNumCalculator();
        addNumCalculator.calculator();
        Console.close();
    }
}
