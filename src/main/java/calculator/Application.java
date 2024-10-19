package calculator;

import calculator.controller.DelimiterController;
import calculator.controller.StringCalculatorController;
import calculator.model.Arithmetic;
import calculator.model.Delimiter;
import calculator.model.InputData;
import calculator.model.SumCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculatorController stringCalculatorController = new StringCalculatorController();
        DelimiterController delimiterController = new DelimiterController();
        InputData inputData = stringCalculatorController.handoverInput();
        Delimiter delimiter = delimiterController.createDelimiterPart(inputData);
        Arithmetic arithmetic = new Arithmetic(delimiter, inputData);
        SumCalculator sumCalculator = new SumCalculator();
        System.out.println("결과 : " + sumCalculator.calculate(arithmetic));
    }
}
