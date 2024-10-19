package calculator;

import calculator.domain.calculation.CalculationFactory;
import calculator.domain.calculation.CalculationFlow;

public class Application {
    public static void main(String[] args) {
        CalculationFlow calculationFlow = CalculationFactory.createCalculationFlow();
        calculationFlow.run();
    }
}
