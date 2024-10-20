package calculator.controller;

import calculator.view.InputReader;
import calculator.view.OutputPrinter;

public class CalculatorController {
    public static void run(){
        OutputPrinter.requestInput();
        String input = InputReader.readInput();
        System.out.println(input); //확인

        Calculator calculator = new Calculator(input);
        calculator.parseInput();






    }
}
