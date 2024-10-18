package calculator.numberExtractor;


import calculator.dto.NumberDto;
import calculator.repository.NumberRepository;
import calculator.validator.Validator;
import java.util.ArrayList;

public class DefaultNumberExtractor implements NumberExtractor {


    public NumberDto extractNumbers(String input, String defaultDelimiter) {

        String[] splitDefaultDelimiter = input.split(defaultDelimiter);
        ArrayList<Integer> repository = new ArrayList<>();
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
        return new NumberDto(numberRepository.getNumberRepository());

    }

}
