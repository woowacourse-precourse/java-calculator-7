package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.parser.DelimiterParser;
import calculator.parser.InputParser;
import calculator.parser.NumberConverter;
import calculator.validator.Validator;
import calculator.view.CalculatorView;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator validator = new Validator();
        DelimiterParser delimiterParser = new DelimiterParser();
        NumberConverter numberConverter = new NumberConverter();
        InputParser inputParser = new InputParser(delimiterParser, numberConverter, validator);
        Calculator calculator = new Calculator(inputParser, validator);
        CalculatorView calculatorView = new CalculatorView();


        CalculatorController calculatorController = new CalculatorController(calculator, calculatorView);
        calculatorController.run(); // 프로그램 실행
    }//main
}//Application
