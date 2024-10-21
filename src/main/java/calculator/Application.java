package calculator;

import java.util.HashSet;

import calculator.calculator.CalculatorService;
import calculator.calculator.CalculatorController;
import calculator.config.DIContainer;

public class Application {
    public static void main(String[] args) {
        DIContainer diContainer = createDIContainer();
        CalculatorController calculatorController = diContainer.getBean(CalculatorController.class);
        calculatorController.run();
    }

    private static DIContainer createDIContainer() {
        var classes = new HashSet<Class<?>>();
        classes.add(CalculatorController.class);
        classes.add(CalculatorService.class);
        return new DIContainer(classes);
    }
}
