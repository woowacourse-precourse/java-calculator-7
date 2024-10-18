package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Calculator {

    public void run() {
        String input_str = InputHandler.getInput();

        String delimiter = ",|:";

        String[] result = CustomDelimeterParser.parse(input_str, delimiter);
        input_str = result[0];
        delimiter = result[1];

        try {
            List<Integer> nums = NumberExtractor.extractNums(input_str, delimiter);
            int sum = nums.stream().mapToInt(Integer::intValue).sum();
            OutputHandler.printResult(sum);
        } catch (IllegalArgumentException e) {
            OutputHandler.printError(e.getMessage());
        }
    }
}
