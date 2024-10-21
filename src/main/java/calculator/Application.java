package calculator;

import java.util.HashSet;

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
        classes.add(Calculator.class);
        return new DIContainer(classes);
    }
}
