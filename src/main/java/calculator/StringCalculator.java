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
        if(input.startsWith("//"){
            int delimiterIndex = input.indexOf("\n");
            if(delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
            String CustomDelimiter = input.substring(2,delimiterIndex);
            this.delimiter = new CustomDelimiter(CustomDelimiter);
            input = input.substring(delimiterIndex+1);
        }
        String[] tokens = delimiter.split(input);
        return sumNumbers(tokens);
    }

}
