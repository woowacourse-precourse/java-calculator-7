package calculator.service;

public class TokenizationService {

    public long[] tokenize(String input){

        StringBuilder delimiterBuilder = new StringBuilder(",|:");

        if(input.startsWith("//")){
            if (!input.substring(0, 2).equals("//") || !input.substring(3, 5).equals("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자가 규칙에 맞지 않습니다.");
            }
            if (Character.isDigit(input.charAt(2))) {
                throw new IllegalArgumentException("커스텀 구분자는 문자여야 합니다.");
            }

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
