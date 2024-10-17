//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.InputParser;
import calculator.view.View;

public class Application {
    public Application() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        InputParser inputParser = new InputParser();
        View view = new View();
        CalculatorController controller = new CalculatorController(calculator, inputParser, view);
        controller.run();
    }
}