package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputParam {

    private Validator validator;

    protected InputParam() {
        this.validator = Validator.of();
    }

    public static InputParam of() {
        return new InputParam();
    }

    public CalculatorParamDomain getUserNumber() {
        String userInput = getInput();
        CalculatorParamDomain domain = CalculatorParamDomain.of();
        List<String> splitEnter = splitInputString(userInput);
        domain.splitStringNumbers(splitEnter);

        if(validator.validDelimiters(userInput)) {
            List<Character> delimiter = findDelimiters(splitEnter);
            domain.changeUserDelimiters(delimiter);
        }

        domain = findNumbers(domain);
        return domain;
    }

    private String getInput() {
        return readLine();
    }

    public CalculatorParamDomain findNumbers(CalculatorParamDomain domain) {
        String stringNumbers = domain.getStringNumbers().getLast();
        List<String> stringNumberList = new ArrayList<>(List.of(stringNumbers));
        for (Character delimiter : domain.getDelimiters()) {
            stringNumberList = splitNumber(stringNumberList, delimiter);
        }
        domain.splitStringNumbers(stringNumberList);
        List<Integer> parseNumbers = validator.tryParseInteger(domain.getStringNumbers());
        domain.parseUserNumbers(parseNumbers);
        return domain;
    }

    public List<String> splitInputString(String inputData) {
        List<String> splitEnter = splitString(inputData, "\n");
        List<String> splitSlash = new ArrayList<>();

        splitEnter.forEach(o -> {
            splitSlash.addAll(splitString(o, "/"));
        });
        return splitSlash;
    }

    public List<Character> findDelimiters(List<String> splitSlash) {
        validator.isNullDelimiters(splitSlash);
        return splitSlash.get(2).chars().mapToObj(c -> (char) c).toList();
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
