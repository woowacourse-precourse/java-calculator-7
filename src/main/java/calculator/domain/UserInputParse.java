package calculator.domain;

import java.util.*;

import static calculator.utils.ParsingUtils.buildRegexFromSet;
import static calculator.utils.ParsingUtils.parsingUserInput;
import static calculator.utils.ValidatorUtils.validateCustomDelimiter;

public class UserInputParse {

    private final Set<String> delimiters = new HashSet<>(Arrays.asList(":",","));

    private final List<Double> numbers;

    public UserInputParse(String userInput) {
        List<String> parsedUserInput = parsingUserInput(userInput);

        if(parsedUserInput.size() == 2){
            String customDelimiter = parsedUserInput.getFirst();
            validateCustomDelimiter(customDelimiter);
            delimiters.add(customDelimiter);
        }

        numbers = parsingNumberString(parsedUserInput.getLast());
    }

    private List<Double> parsingNumberString(String numberString){
        String regex = buildRegexFromSet(delimiters);
        String[] parsedNumberString = numberString.split(regex);

        List<Double> numbers = new ArrayList<>();

        for (String string : parsedNumberString) {
            try {
                numbers.add(Double.valueOf(string));
            }catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }

        return numbers;
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public List<Double> getNumbers() {
        return numbers;
    }
}
