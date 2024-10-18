package calculator.service;

import calculator.domain.UserInput;

public class ParserService {

    public Integer checkUserInputEmpty(UserInput userInput) {
        if (userInput.getText().isEmpty()) {
            return 0;
        } else {
            return null;
        }
    }

}
