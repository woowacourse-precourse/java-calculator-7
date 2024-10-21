package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static calculator.CalculatorConst.*;

public class InputParser {

    public List<Integer> parseInputToIntList(String input) {
        ParserPolicy policy = ParserPolicy.strategy(input);
        String standardize = policy.parseAndStandardize(input);
        return convertToIntList(standardize);
    }

    private List<Integer> convertToIntList(String input) {
        if (input.isEmpty()) return List.of(0);
        return Arrays.stream(input.split(COMMON_DELIMITER))
                .map(Validator::validateIfNotNumber)
                .map(Validator::validateIfInputNegative)
                .toList();
    }
}
