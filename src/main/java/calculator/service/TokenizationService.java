package calculator.service;

public class TokenizationService {

    private final CustomDelimiterChecker customDelimiterChecker;
    private final Converter converter;

    public TokenizationService(CustomDelimiterChecker customDelimiterChecker, Converter converter) {
        this.customDelimiterChecker = customDelimiterChecker;
        this.converter = converter;
    }

    public long[] tokenize(String input){

        StringBuilder delimiterBuilder = new StringBuilder(",|:");

        if(input.startsWith("//")){
            customDelimiterChecker.checkCustomDelimiterRule(input);
            customDelimiterChecker.checkCustomDelimiter(input);

            delimiterBuilder.append("|").append(input.charAt(2));

            input = input.substring(5);
        }

        String[] nums = input.split(delimiterBuilder.toString());

        long[] numbers = new long[nums.length];
        int idx = 0;
        for(String numStr : nums){
            numbers[idx++] = converter.convertToOperand(numStr);
        }

        return numbers;

    }
}
