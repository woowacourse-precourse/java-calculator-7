package calculator.service;

import calculator.domain.Delimiters;
import java.util.ArrayList;
import java.util.List;

public class StringSplitter {
    private final Delimiters delimiters;

    public StringSplitter(Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public List<String> split(String input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }
        
        return List.of(input.split(delimiters.createRegexPattern()));
    }
}