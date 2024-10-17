package calculator.model;

import java.util.List;

public class Parser {

    private List<String> parseBasicSeparator(String input){
        List<String> splitString = List.of(input.split(",|:"));

        return splitString;
    }
}
