package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController calculatorController = new CalculatorController();
        Long result = calculatorController.startCalculate();
        System.out.println("결과 : " + result);
    }
}
