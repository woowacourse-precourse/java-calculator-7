package calculator;

import calculator.domain.CharAnalyzer;
import calculator.domain.CustomDelimiter;
import calculator.domain.Delimiter;
import calculator.domain.SumCalculator;
import calculator.input.InputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        inputHandler.showMessage();
        String input = inputHandler.input();

        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        SumCalculator sumCalculator = new SumCalculator();

        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiter, sumCalculator);
        charAnalyzer.analyzeAllChars();

        System.out.println(sumCalculator.getResult());
    }
}