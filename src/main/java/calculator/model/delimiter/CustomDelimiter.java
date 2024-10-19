package calculator.model.delimiter;

public class CustomDelimiter implements Delimiter {
    @Override
    public String getDelimiter(String input) {
        String customDelimiter = String.valueOf(input.charAt(2));
        return new DefaultDelimiter().getDelimiter(input) + customDelimiter;
    }
}
