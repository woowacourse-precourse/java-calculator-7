package calculator.model;

public class DelimiterParser {
    private static final String DELIMITERS = ",|:";

    public String parseDelimiter(String input){
        if(input.startsWith("//")){
            int index = input.indexOf("\\n");

            Validator.checkCustomDelimiter(index);

            String customDelimiter = input.substring(2, index);
            return DELIMITERS + "|" + customDelimiter;
        }
        return DELIMITERS;
    }

    public String extractNumbers(String input){
        if(input.startsWith("//")){
            int index = input.indexOf("\\n");
            return input.substring(index + 2);
        }
        return input;
    }
}
