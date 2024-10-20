package calculator.numberExtractor;


import calculator.constants.StringConst;
import calculator.dto.NumberDto;
import calculator.repository.NumberRepository;
import calculator.validator.Validator;

public class CustomNumberExtractor implements NumberExtractor {
    private final Validator validator;

    public CustomNumberExtractor(Validator validator) {
        this.validator = validator;
    }

    public NumberDto extractNumbers(String input, String customDelimiter) {

        validator.isHaveNextToken(input);
        String[] nextToken = splitNextToken(input, customDelimiter);
        NumberRepository numberRepository = new NumberRepository();
        saveValidatedNumber(nextToken, numberRepository);
        return numberRepository.getNumberDto();

    }

    private String[] splitNextToken(String input, String customDelimiter) {
        return input.split(StringConst.LINE_SEPARATOR_REGEX)[1].split(customDelimiter);
    }


    private void saveValidatedNumber(String[] splitDelimiter, NumberRepository numberRepository) {
        for (String split : splitDelimiter) {

            int parseNumber = parseNumber(split);
            validator.validate(parseNumber);
            numberRepository.saveNumber(parseNumber);
        }
    }


}
