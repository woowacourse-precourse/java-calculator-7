package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Split {

    protected Split() {
    }

    public static Split of() {
        return new Split();
    }

    public List<String> splitInputOfEnter(String inputData) {
        List<String> splitEnter = splitString(inputData, "\n");
        List<String> splitSlash = new ArrayList<>();

        splitEnter.forEach(o -> {
            splitSlash.addAll(splitString(o, "/"));
        });
        return splitSlash;
    }

    public void splitNumberOfDelimiter(CalculatorParamDomain domain) {
        String stringNumbers = domain.getStringNumbers().getLast();
        List<String> stringNumberList = new ArrayList<>(List.of(stringNumbers));

        for (Character delimiter : domain.getDelimiters()) {
            stringNumberList = splitNumber(stringNumberList, delimiter);
        }
        domain.splitStringNumbers(stringNumberList);
    }

    private List<String> splitNumber(List<String> inputNumberData, Character delimiters) {
        List<String> stringNumberList = new ArrayList<>();

        inputNumberData.forEach(i -> {
            stringNumberList.addAll(splitString(i, delimiters.toString()));
        });
        return stringNumberList;
    }

    private List<String> splitString(String input, String regex) {
        return Arrays.stream(input.split(regex)).toList();
    }
}
