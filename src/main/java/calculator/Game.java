package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class Game {
    public void start() {
        String input = readLine();

        Separator separator = new Separator();
        String splitInputWithSeparator = separator.containCustomSeparator(input);

        Input input1 = new Input(splitInputWithSeparator);

        String[] splitStr = input1.splitBySeparator(separator);
        int[] numbers = input1.convertToIntArray(splitStr);
        System.out.println(Arrays.stream(numbers).sum());
    }
}
