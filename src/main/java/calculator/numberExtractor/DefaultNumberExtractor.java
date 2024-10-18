package calculator.numberExtractor;


import calculator.dto.NumberDto;
import calculator.repository.NumberRepository;
import calculator.validator.Validator;

public class DefaultNumberExtractor implements NumberExtractor {


    public NumberDto extractNumbers(String input, String defaultDelimiter) {

        String[] splitDefaultDelimiter = input.split(defaultDelimiter);
        NumberRepository numberRepository = new NumberRepository();
        saveValidatedNumber(splitDefaultDelimiter, numberRepository);
        return numberRepository.getNumberDto();

    }


    private static void saveValidatedNumber(String[] splitDefaultDelimiter, NumberRepository numberRepository) {
        for (String splitDefault : splitDefaultDelimiter) {

            int parseNumber = parseNumber(splitDefault);
            numberRepository.saveNumber(parseNumber);

        }
    }

    private static int parseNumber(String splitDefault) {

        try {
            int parseInt = Integer.parseInt(splitDefault);
            Validator.validate(parseInt);
            return parseInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
