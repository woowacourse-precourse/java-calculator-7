package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.Validator;
import calculator.view.InputReader;
import calculator.view.OutputWriter;

public class Application {
    public static void main(String[] args) {

        // InputReader, OutputWriter 인스턴스 생성
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        Validator validator = new Validator();
        Calculator calculator = new Calculator();

        // CalculatorController 인스턴스 생성
        CalculatorController calculatorController = new CalculatorController(inputReader, outputWriter, validator, calculator);

        // 덧셈 계산 시작
        calculatorController.run();
    }
}