package calculator.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorServiceImpl implements StringCalculatorService {

    private final StringCalculatorRepository stringCalculatorRepository;

    public StringCalculatorServiceImpl(StringCalculatorRepository stringCalculatorRepository) {
        this.stringCalculatorRepository = stringCalculatorRepository;
    }

    @Override
    public void validateInputForm(String input) {
        if (!input.matches("//.+\\n.*") && !input.matches("^[0-9:,]*$")) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String calculate(String input) {

        return "";
    }

    @Override
    public String extractDelimiter(String input) {

        return "";
    }

    @Override
    public void validateInputDelimiter(String input) {

    }

    @Override
    public void extractNumber(String input) {

    }

}
