package calculator.delimiterExtractor;

import calculator.constants.StringConst;

public class DefaultDelimiterExtractor implements DelimiterExtractor {


    public String extractDelimiter(String input) {

        return StringConst.DEFAULT_DELiMITER;
    }


}