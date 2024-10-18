package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.view.InputPrint;
import calculator.view.OutputPrint;
import java.util.Arrays;

public class Game {
    public void start() {
        InputPrint.printInput();
        String input = readLine();

        Separator separator = new Separator();
        String splitInputWithSeparator = separator.containCustomSeparator(input);

        Input input1 = new Input(splitInputWithSeparator);

        String[] splitStr = input1.splitBySeparator(separator);
        int[] numbers = input1.convertToIntArray(splitStr);
        OutputPrint.printResult(Arrays.stream(numbers).sum());
    }
}
