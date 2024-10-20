package calculator.numberExtractor;


import calculator.dto.NumberDto;
import calculator.repository.NumberRepository;

public class DefaultNumberExtractor implements NumberExtractor {


    public NumberDto extractNumbers(String input, String defaultDelimiter) {

        String[] splitDefaultDelimiter = input.split(defaultDelimiter);
        NumberRepository numberRepository = new NumberRepository();
        saveValidatedNumber(splitDefaultDelimiter, numberRepository);
        return numberRepository.getNumberDto();

    }


    private void saveValidatedNumber(String[] splitDefaultDelimiter, NumberRepository numberRepository) {
        for (String splitDefault : splitDefaultDelimiter) {

            int parseNumber = parseNumber(splitDefault);
            numberRepository.saveNumber(parseNumber);

        }
    }


}
