package calculator.numberExtractor;


import calculator.dto.NumberDto;
import calculator.repository.NumberRepository;
import calculator.validator.Validator;

public class DefaultNumberExtractor implements NumberExtractor {


    public NumberDto extractNumbers(String input, String defaultDelimiter) {

        String[] splitDefaultDelimiter = input.split(defaultDelimiter);
        NumberRepository numberRepository = new NumberRepository();

        for (String splitDefault : splitDefaultDelimiter) {
            int parseInt = 0;

            try {
                parseInt = Integer.parseInt(splitDefault);
                Validator.validate(parseInt);
                numberRepository.saveNumber(parseInt);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

        }
        return numberRepository.getNumberDto();

    }

}
