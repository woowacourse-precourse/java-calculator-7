package calculator.numberExtractor;


import calculator.constants.StringConst;
import calculator.dto.NumberDto;
import calculator.repository.NumberRepository;
import calculator.validator.Validator;

public class CustomNumberExtractor implements NumberExtractor {


    public NumberDto extractNumbers(String input, String customDelimiter) {

        Validator.isHaveNextToken(input);
        String[] nextToken = splitNextToken(input, customDelimiter);
        NumberRepository numberRepository = new NumberRepository();
        saveValidatedNumber(nextToken, numberRepository);
        return numberRepository.getNumberDto();

    }

    private static String[] splitNextToken(String input, String customDelimiter) {
        return input.split(StringConst.LINE_SEPARATOR_REGEX)[1].split(customDelimiter);
    }


    private static void saveValidatedNumber(String[] splitDelimiter, NumberRepository numberRepository) {
        for (String split : splitDelimiter) {

            int parseNumber = parseNumber(split);
            Validator.validate(parseNumber);
            numberRepository.saveNumber(parseNumber);
        }
    }


    private static int parseNumber(String split) {

        try {
            int parseInt = Integer.parseInt(split);
            return parseInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }


}
