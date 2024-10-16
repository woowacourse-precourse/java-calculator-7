package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberParser {
    public ArrayList<String> inputNumberParse(String[] separatoredString) {
        String separator = separatoredString[0];
        ArrayList<String> operandList = new ArrayList<>();
        operandList.addAll(Arrays.stream(separatoredString[1].split(separator))
                .map(String::trim)
                .filter(s -> s.matches("\\d+"))
                .toList());
        return operandList;
    }
}
