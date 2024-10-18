package calculator.numberExtractor;

import calculator.validator.Validator;
import java.util.ArrayList;

public class DefaultNumberExtractor implements NumberExtractor {


    public ArrayList<Integer> extractNumbers(String input, String defaultDelimiter) {

        String[] splitDefaultDelimiter = input.split(defaultDelimiter);
        ArrayList<Integer> repository = new ArrayList<>();
        for (String splitDefault : splitDefaultDelimiter) {
            int parseInt = 0;

            try {
                parseInt = Integer.parseInt(splitDefault);
                Validator.validate(parseInt);
                repository.add(parseInt);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

        }
        return repository;

    }

}
