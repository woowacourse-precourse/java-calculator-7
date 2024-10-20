package calculator;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        try{
            new CalculatorController().run();
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
