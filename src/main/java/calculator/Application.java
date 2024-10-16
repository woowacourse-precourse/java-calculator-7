package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputReader;
import calculator.view.OutputWriter;

public class Application {
    public static void main(String[] args) {

        // InputReader, OutputWriter 인스턴스 생성
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();

        // CalculatorController 인스턴스 생성
        CalculatorController calculatorController = new CalculatorController(inputReader, outputWriter);

        // 덧셈 계산 시작
        calculatorController.run();
    }
}