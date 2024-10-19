package calculator;

import calculator.controller.CalculatorController;

public class Application {

    public static void main(String[] args) {
        try{
            CalculatorController calculatorController = new CalculatorController();
            calculatorController.startCalculating();
        }catch(IllegalArgumentException e){

        }
    }
}
