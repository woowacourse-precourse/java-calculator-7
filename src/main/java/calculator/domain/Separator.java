package calculator.domain;

import calculator.util.RegexGenerator;
import java.util.Arrays;
import java.util.List;

public class Separator {

    public List<String> separateByDelimiter(String input, String delimiter) {
        String delimiterRegex = RegexGenerator.generateRegex(delimiter);
        return Arrays.asList(input.split(delimiterRegex));
    }
}