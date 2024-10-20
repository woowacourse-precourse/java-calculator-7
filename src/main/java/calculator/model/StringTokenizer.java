package calculator.model;

import calculator.validator.InputValidatorUtils;

import java.util.ArrayList;
import java.util.List;

public class StringTokenizer implements Tokenizer {
    private final StringBuilder delimiters;

    public StringTokenizer(StringBuilder delimiters) {
        this.delimiters = delimiters;
        addDelimiter(",");
        addDelimiter(":");
    }

    private void addDelimiter(String delimiter) {
        if (InputValidatorUtils.isSpecialDelimiter(delimiter)) {
            delimiters.append("\\");
        }

        delimiters.append(delimiter);
    }

    private List<String> tokenize(String input) {
        String string = input;

        if (InputValidatorUtils.customDelimiterContains(string)) {
            string = addCustomDelimiter(string);
        }

        java.util.StringTokenizer st = new java.util.StringTokenizer(string, delimiters.toString());
        List<String> stringList = new ArrayList<>();

        while(st.hasMoreTokens()) {
            stringList.add(st.nextToken());
        }

        return stringList;
    }

    @Override
    public List<Integer> InputString2IntegerList(String input) {
        if(input.isBlank()) {
            return List.of(0);
        }

        List<String> inputList = tokenize(input);
        List<Integer> list = inputList.stream()
                .map(Integer::valueOf)
                .toList();

        if(InputValidatorUtils.hasNegativeValue(list)) {
            return list;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String addCustomDelimiter(String input) {
        String[] split = input.split("//|\\\\n");
        addDelimiter(split[1]);

        return split[2];
    }
}
