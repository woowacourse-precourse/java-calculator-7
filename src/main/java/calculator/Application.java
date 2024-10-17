package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CalculatorController calculatorController = new CalculatorController();

        // 입력 받기
        calculatorController.displayInputView();
        calculatorController.getUserInput();

        // 계산 하기
        calculatorController.calculate();

        // 출력하기
        calculatorController.displayOutputView();
    }
}
