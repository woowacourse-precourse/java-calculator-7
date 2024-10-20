package calculator.controller;

import static calculator.util.Io.input;
import static calculator.util.Io.printResult;

import calculator.util.Converter;
import java.util.List;

public class CalculatorController {
    public static void run() {
        String input = input();
        List<Integer> numbers = Converter.stringToNumbers(input);
        int result = numbers.stream().mapToInt(i -> i).sum();
        printResult(result);
    }
}
