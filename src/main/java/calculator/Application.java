package calculator;

import calculator.presentation.CalculatorRunner;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try{
            CalculatorRunner.run();
        } finally {
            Console.close();
        }
    }
}
