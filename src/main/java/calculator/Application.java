package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController calculatorController = new CalculatorController();
        System.out.println("결과 : " + calculatorController.startCalculate());
    }
}
