package calculator.domain;

import static calculator.domain.MathOperator.getSum;

import camp.nextstep.edu.missionutils.Console;
import java.util.Vector;

public class InputProcessor {
    private String inputString;
    private int result = 0;
    private Vector<Integer> extractedNumbers = new Vector<>();
    private InputParser inputParser = new InputParser();

    public void setInputString() {
        this.inputString = Console.readLine();
    }

    public void processInputString() {
        if (!inputString.isEmpty()) {
            inputParser.parseInput(inputString, extractedNumbers);
            result = getSum(extractedNumbers);
        }

    }

    public int getResult() {
        return result;
    }
}
