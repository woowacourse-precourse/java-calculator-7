package calculator;

import calculator.domain.CalculateManager;

public class Application {
    public static void main(String[] args) {
        CalculateManager calculateManager = new CalculateManager();
        calculateManager.start();
    }
}
