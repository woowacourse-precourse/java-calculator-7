package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.view.InputPrint;
import calculator.view.OutputPrint;
import java.util.Arrays;

public class Game {

    public void start() {
        String input = getUserInput();
        Separators separators = new Separators();

        String processedInput = processInput(input, separators);
        int[] numbers = convertInputToNumbers(processedInput, separators);

        printResult(numbers);
    }

    private String getUserInput() {
        InputPrint.printInput();
        return readLine();
    }

    private String processInput(String input, Separators separators) {
        return separators.containCustomSeparator(input);
    }

    private int[] convertInputToNumbers(String input, Separators separators) {
        Input inputProcessor = new Input(input);
        String[] splitStr = inputProcessor.splitBySeparator(separators);
        return inputProcessor.convertToIntArray(splitStr);
    }

    private void printResult(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        OutputPrint.printResult(numbers.length == 0 ? 0 : sum);
    }
}
