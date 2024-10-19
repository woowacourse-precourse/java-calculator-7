package calculator.controller;

import calculator.model.Dto.DelimiterInputData;
import calculator.model.NumberParser;
import calculator.model.validator.InputValidator;
import java.util.List;

public class InputProcessor {

    private NumberParser numberParser;

    public InputProcessor(String input) {

        InputValidator inputValidator = new InputValidator(input);

        DelimiterInputData delimiterInputData = inputValidator.validatedData();

        numberParser = new NumberParser(delimiterInputData);

    }

    public List<Long> numbers() {

        return numberParser.extractNumbers();
    }
}
