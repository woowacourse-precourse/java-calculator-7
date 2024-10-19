package calculator.domain;

import java.util.*;

import static calculator.constant.ExceptionConstant.NUMBER_FORMAT_EXCEPTION;
import static calculator.utils.ParsingUtils.buildMultiDelimiterFromSet;
import static calculator.utils.ParsingUtils.splitUserInputTowPart;
import static calculator.utils.ValidatorUtils.validateCustomDelimiter;

public class InputParsing {
    private final Set<String> delimiters = new HashSet<>(Arrays.asList(":",","));
    private final List<Double> numbers;

    public InputParsing(String userInput) {
        List<String> towPartUserInput = splitUserInputTowPart(userInput);
        addCustomDelimiter(towPartUserInput);
        numbers = parsingStringToNumbers(towPartUserInput.getLast());
    }

    private void addCustomDelimiter(List<String> parsedUserInput){
        if(parsedUserInput.size() != 2){
            return;
        }

        String customDelimiter = parsedUserInput.getFirst();
        validateCustomDelimiter(customDelimiter);
        delimiters.add(customDelimiter);
    }

    private List<Double> parsingStringToNumbers(String numberString){
        String regex = buildMultiDelimiterFromSet(delimiters);

        return Arrays.stream(numberString.split(regex))
                .map(this::changeToDouble)
                .toList();
    }

    private Double changeToDouble(String number) {
        try {
            return Double.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public List<Double> getNumbers() {
        return numbers;
    }
}
