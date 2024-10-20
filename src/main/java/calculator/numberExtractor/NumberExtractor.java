package calculator.numberExtractor;


import calculator.dto.NumberDto;
import calculator.validator.Validator;

public interface NumberExtractor {


    public NumberDto extractNumbers(String input, String delimiter);

    default int parseNumber(String splitDefault) {

        try {
            int parseInt = Integer.parseInt(splitDefault);
            Validator.validate(parseInt);
            return parseInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
