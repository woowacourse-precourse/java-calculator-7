package calculator.numberExtractor;


import calculator.dto.NumberDto;
import calculator.repository.NumberRepository;
import calculator.validator.Validator;

public class CustomNumberExtractor implements NumberExtractor {


    public NumberDto extractNumbers(String input, String customDelimiter) {

        Validator.isHaveNextToken(input);
        String[] splitDelimiter = input.split("\\\\n")[1].split(customDelimiter);
        NumberRepository numberRepository = new NumberRepository();

        for (String split : splitDelimiter) {

            int parseInt = 0;
            try {
                parseInt = Integer.parseInt(split);
                Validator.validate(parseInt);
                numberRepository.saveNumber(parseInt);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return numberRepository.getNumberDto();

    }


}
