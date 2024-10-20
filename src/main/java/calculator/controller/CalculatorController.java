package calculator.controller;

import calculator.model.Separator;
import calculator.view.InputReader;
import calculator.view.OutputPrinter;

import static calculator.model.Separator.activeSeparator;

public class CalculatorController {
    public static void run(){
        OutputPrinter.requestInput();
        String input = InputReader.readInput();
        System.out.println(input); //확인

        Calculator calculator = new Calculator();
        String token = Separator.checkCustomSeparator(input);
        System.out.println("결말; 토큰 상태: " + token + " 활성 구분자: " + activeSeparator);







    }
}
