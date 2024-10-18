package calculator.delimiterExtractor;

public class DefaultDelimiterExtractor implements DelimiterExtractor {


    public String extractDelimiter(String input) {

        return ",|:";
    }


}