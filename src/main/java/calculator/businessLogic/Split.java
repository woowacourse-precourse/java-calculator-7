package calculator.businessLogic;

import calculator.domain.CalculatorParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.message.Message.구분자시작;
import static calculator.message.Message.입력끝구분자;

public class Split {

    protected Split() {
    }

    public static Split of() {
        return new Split();
    }

    public List<String> splitInputOfEnter(String inputData) {
        List<String> splitEnter = splitString(inputData, 입력끝구분자);
        List<String> splitSlash = new ArrayList<>();

        splitEnter.forEach(o -> {
            splitSlash.addAll(splitString(o, 구분자시작));
        });
        return splitSlash;
    }

    public void splitNumberOfDelimiter(CalculatorParam domain) {
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
