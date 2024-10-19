package calculator.domain;

import java.util.*;

import static calculator.utils.ParsingUtils.parsingUserInput;
import static calculator.utils.ValidatorUtils.validateCustomDelimiter;

public class UserInputParse {

    private final Set<String> delimiters = new HashSet<>(Arrays.asList(":",","));

    public UserInputParse(String userInput) {
        List<String> parsedUserInput = parsingUserInput(userInput);

        if(parsedUserInput.size() == 2){
            String customDelimiter = parsedUserInput.getFirst();
            validateCustomDelimiter(customDelimiter);
            delimiters.add(customDelimiter);
        }
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }
}
