//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.InputParser;
import calculator.view.View;

public class CalculatorController {
    private final Calculator calculator;
    private final InputParser inputParser;
    private final View view;

    public CalculatorController(Calculator calculator, InputParser inputParser, View view) {
        this.calculator = calculator;
        this.inputParser = inputParser;
        this.view = view;
    }

    public void run() {
        try {
            String input = this.view.getInput();
            String[] parsedNumbers = this.inputParser.parse(input).getNumbers();
            int result = this.calculator.add(parsedNumbers);
            this.view.printResult(result);
        } catch (IllegalArgumentException var4) {
            this.view.printError(var4.getMessage());
            throw var4;
        }
    }
}