package calculator;

import calculator.domain.CalculateMannager;

public class Application {
    public static void main(String[] args) {
        CalculateMannager calculateMannager = new CalculateMannager();
        calculateMannager.start();
    }
}
