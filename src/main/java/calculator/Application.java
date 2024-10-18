package calculator;

import calculator.formatter.InputHandler;
import calculator.formatter.OutputHandler;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputHandler.printInputPrompt();
        String input = InputHandler.input();

        NumberExtractor extractor = new NumberExtractor(input);
        int resultSum = extractor.extractNumber();

        OutputHandler.printOutputResult(resultSum);

        InputHandler.close();
    }
}
