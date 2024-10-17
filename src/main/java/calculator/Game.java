package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class Game {
    public void start() {
        String input = readLine();
        Input input1 = new Input(input);

        String customSeparator = customSeparator(input1);

        Separator separator = new Separator(customSeparator);
        String[] splitStr = input1.separatorInput(separator);
        int[] numbers = input1.changeInteger(splitStr);
        System.out.println(Arrays.stream(numbers).sum());
    }

    private String customSeparator(Input input1) {
        if (input1.getInput().startsWith("//") && input1.getInput().contains("\n")) {
            return input1.getInput().substring(2, 3);
        }
        return null;
    }
}
