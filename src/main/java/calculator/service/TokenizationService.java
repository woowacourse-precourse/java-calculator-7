package calculator.service;

public class TokenizationService {

    private final CustomDelimiterChecker customDelimiterChecker;

    public TokenizationService(CustomDelimiterChecker customDelimiterChecker) {
        this.customDelimiterChecker = customDelimiterChecker;
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
            try {
                long num = Long.parseLong(numStr);

                if (num <= 0) {
                    throw new IllegalArgumentException("입력 숫자가 양수가 아닙니다.");
                }
                numbers[idx++] = num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("커스텀 구분자, 숫자 외 다른 문자가 존재합니다.");
            }
        }

        return numbers;

    }
}
