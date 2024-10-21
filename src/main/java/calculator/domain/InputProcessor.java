package calculator.domain;

import static calculator.domain.MathOperator.getSum;

import camp.nextstep.edu.missionutils.Console;
import java.util.Vector;

public class InputProcessor {
    private String inputString;
    private int result = 0;
    private final Vector<Integer> extractedNumbers = new Vector<>();
    private final InputParser inputParser = new InputParser();

    public void setInputString() {
        this.inputString = Console.readLine();
    }

    public void processInputString() {
        if (!inputString.trim().isEmpty()) {
            inputParser.parseInput(inputString.trim(), extractedNumbers);
            result = getSum(extractedNumbers);
        }
    }

    public int getResult() {
        return result;
    }
}
