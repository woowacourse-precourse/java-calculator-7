package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class Game {
    public void start() {
        String input = readLine();
        Input input1 = new Input(input);
        List<String> separator = Arrays.asList(",", ":");
        String[] splitStr = input1.separatorInput(separator);
        int[] numbers = input1.changeInteger(splitStr);
        System.out.println(Arrays.stream(numbers).sum());
    }


}
