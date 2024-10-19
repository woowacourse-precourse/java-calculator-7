package calculator;

import calculator.io.InputHandler;
import calculator.splitor.Splitor;
import calculator.util.IntegerConverter;
import calculator.util.SplitorExtractor;

import java.util.List;

public class Calculator {
    public void run() {
        InputHandler inputHandler = new InputHandler();
        InputString inputString = inputHandler.getInputString();

        if (inputString == null || inputString.isBlank()) {
            // 0 출력
            return;
        }

        SplitorExtractor splitorExtractor = new SplitorExtractor();

        Splitor splitor = splitorExtractor.extractSplitor(inputString);
        List<String> stringList = splitor.split();
        List<Integer> integerList = IntegerConverter.convertToIntegerList(stringList);

    }
}
