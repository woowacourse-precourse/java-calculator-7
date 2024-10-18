package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    public String inputString() {
        return Console.readLine();
    }

    public List<Integer> extractNumbers(String input) {
        List<String> parsedString = parseString(input);

        return parsedString.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> parseString(String str) {
        String[] result = str.split(DEFAULT_DELIMITER_REGEX);
        return Arrays.asList(result);
    }
}
