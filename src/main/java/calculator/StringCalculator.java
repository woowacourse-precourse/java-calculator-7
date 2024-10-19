package calculator;

public class StringCalculator {
    private Delimiter delimiter;

    public StringCalculator() {
        this.delimiter = new BasicDelimiter();
    }

    public StringCalculator(String customDelimiter) {
        this.delimiter = new CustomDelimiter(customDelimiter);
    }

    public int add(String input) {
        if(input == null||input.isEmpty()) {
            return 0;
        }
        if(input.startsWith("//")){
            int delimiterIndex = input.indexOf("\\n");
            if(delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
            String customDelimiter = input.substring(2,delimiterIndex);
            this.delimiter = new CustomDelimiter(customDelimiter);
            input = input.substring(delimiterIndex+2);
        }
        String[] tokens = delimiter.split(input);
        return sumNumbers(tokens);
    }

    private int sumNumbers(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += validateNumber(token);
        }
        return sum;
    }

    private int validateNumber(String token) {
        try{
            return Integer.parseInt(token);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }
}
