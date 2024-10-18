package calculator.model;

public class DelimiterParser {
    private static final String DELIMITERS = ",|:";
    private final String DELIMITER_PREFIX = "//";
    private final String DELIMITER_END = "\\n";

    public String parseDelimiter(String input){
        if(input.startsWith(DELIMITER_PREFIX)){
            int index = input.indexOf(DELIMITER_END);

            Validator.checkCustomDelimiter(index);

            String customDelimiter = input.substring(2, index);
            return DELIMITERS + "|" + customDelimiter;
        }
        return DELIMITERS;
    }

    public String extractNumbers(String input){
        if(input.startsWith(DELIMITER_PREFIX)){
            int index = input.indexOf(DELIMITER_END);
            return input.substring(index + 2);
        }
        return input;
    }
}
