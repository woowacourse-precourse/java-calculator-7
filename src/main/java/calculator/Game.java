package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.view.InputPrint;
import calculator.view.OutputPrint;
import java.util.Arrays;

public class Game {
    public void start() {
        InputPrint.printInput();
        String input = readLine();

        Separators separators = new Separators();
        String splitInputWithSeparator = separators.containCustomSeparator(input);

        Input input1 = new Input(splitInputWithSeparator);

        String[] splitStr = input1.splitBySeparator(separators);
        int[] numbers = input1.convertToIntArray(splitStr);

        if (numbers.length == 0) {
            OutputPrint.printResult(0);
            return;
        }
        OutputPrint.printResult(Arrays.stream(numbers).sum());
    }
}
