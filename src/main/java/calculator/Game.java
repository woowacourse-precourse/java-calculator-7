package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class Game {
    public void start() {
        String input = readLine();
        Input input1 = new Input(input);
        Separator separator = new Separator();
        String[] splitStr = input1.separatorInput(separator);
        int[] numbers = input1.changeInteger(splitStr);
        System.out.println(Arrays.stream(numbers).sum());
    }


}
