package calculator.view;

import calculator.domain.Delimeters;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public List<Integer> parseInput(Delimeters delimiters, String input) {
        String delimiterRegex = String.join("|", delimiters.getElements());
        String[] tokens = input.split(delimiterRegex);
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }
}
