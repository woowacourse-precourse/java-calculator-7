package calculator;

import calculator.domain.*;
import calculator.input.InputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        inputHandler.showMessage();
        String input = inputHandler.input();

        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        SumCalculator sumCalculator = new SumCalculator();
        NumberGenerator numberGenerator = new NumberGenerator(sumCalculator);

        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiter, numberGenerator);
        charAnalyzer.analyzeAllChars();

        System.out.println(sumCalculator.getResult());

    }
}