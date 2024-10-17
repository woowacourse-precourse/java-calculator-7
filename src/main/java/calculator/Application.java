package calculator;

import calculator.domain.CharAnalyzer;
import calculator.domain.CustomDelimiter;
import calculator.domain.Delimiter;
import calculator.input.InputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        inputHandler.showMessage();
        String input = inputHandler.input();

        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiter);

        try {
            charAnalyzer.analyzeAllChars();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}