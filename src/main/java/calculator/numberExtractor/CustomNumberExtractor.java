package calculator.numberExtractor;

import calculator.validator.Validator;
import java.util.ArrayList;

public class CustomNumberExtractor implements NumberExtractor {


    public ArrayList<Integer> extractNumbers(String input, String customDelimiter) {
        Validator.isHaveNextToken(input);

        String[] splitDelimiter = input.split("\\\\n")[1].split(customDelimiter);
        ArrayList<Integer> repository = new ArrayList<>();
        for (String split : splitDelimiter) {

            int parseInt = 0;
            try {
                parseInt = Integer.parseInt(split);
                Validator.validate(parseInt);
                repository.add(parseInt);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return repository;

    }


}
