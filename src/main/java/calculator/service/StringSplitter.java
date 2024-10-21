package calculator.service;

import calculator.domain.delimeter.Delimiters;
import java.util.ArrayList;
import java.util.List;

public class StringSplitter {
    public List<String> split(String input, Delimiters delimiters) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        return List.of(input.split(delimiters.createRegexPattern()));
    }
}