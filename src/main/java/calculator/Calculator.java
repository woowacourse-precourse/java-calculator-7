package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.splitor.Splitor;
import calculator.util.SplitorExtractor;

public class Calculator {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final SplitorExtractor splitorExtractor = new SplitorExtractor();
    public void run() {
        InputString inputString = inputHandler.getInputString();

        Splitor splitor = splitorExtractor.extractSplitor(inputString);
        SplittedResult splittedResult = splitor.split();
        int sum = splittedResult.sum();

        outputHandler.outputResult(sum);
    }

    public void validate(InputString inputString) {
        String str = inputString.getInputString();
        if (str.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("문자열에 숫자가 없고 문자만 있습니다.");
        }
    }
}
