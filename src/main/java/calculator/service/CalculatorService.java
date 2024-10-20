package calculator.service;

public class CalculatorService {

    private static final String DEFAULT_DELIMITERS = ",|:";
    public int add(String input){
        if (input == null || input.isEmpty()){
            return 0;
        }

        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        String[] tokens = numbers.split(delimiter);
        return 0;
    }
}
