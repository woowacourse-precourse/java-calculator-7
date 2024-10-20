package calculator.controller;

import calculator.model.NumberConverter;
import calculator.model.Separator;
import calculator.view.InputReader;
import calculator.view.OutputPrinter;

import java.util.Arrays;

import static calculator.model.Separator.*;

public class CalculatorController {
    public static void run(){
        OutputPrinter.requestInput();
        String input = InputReader.readInput();
        System.out.println(input); //확인

        Calculator calculator = new Calculator();
        String token = Separator.checkCustomSeparator(input);
        System.out.println("결말; 토큰 상태: " + token + " 활성 구분자: " + activeSeparator);
        String[] tokens = splitInput(token);
        System.out.println(Arrays.toString(tokens));
        int result = calculator.sum(tokens);
        System.out.println(result);

    }
}
