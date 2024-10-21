package calculator;

import calculator.calculator.CalculatorController;
import calculator.global.CustomBeanFactory;

public class Application {
    public static void main(String[] args) {
        CustomBeanFactory customBeanFactory = new CustomBeanFactory();
        CalculatorController calculatorController = customBeanFactory.calculatorController();
        calculatorController.run();
    }
}
