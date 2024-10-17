package calculator;

public class DelimiterParser {
    private static final String DELIMITERS = ",|:";

    public String parseDelimiter(String input){
        if(input.startsWith("//")){
            int index = input.indexOf("\\n");
            String customDelimiter = input.substring(2, index);
            return DELIMITERS + "|" + customDelimiter;
        }
        return DELIMITERS;
    }
}
