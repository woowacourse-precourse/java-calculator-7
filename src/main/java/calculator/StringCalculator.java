package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int calculate(String input){
        if(input == null || input.isEmpty()){
            return 0;
        }

        ParsedInput parsedInput = InputParser.parse(input);
        List<Integer> numbers = parsedInput.numbers();

        return numbers.stream().reduce(0, Integer::sum);
    }
}
