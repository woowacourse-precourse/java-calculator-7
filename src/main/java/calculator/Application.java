package calculator;

import calculator.domain.CalculationManager;
import calculator.factory.CalculationFactory;

public class Application {
    public static void main(String[] args) {
        CalculationFactory factory = new CalculationFactory();
        CalculationManager manager = factory.createCalculationManager();
        manager.run();
    }
}
