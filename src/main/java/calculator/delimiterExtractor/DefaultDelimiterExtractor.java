package calculator.delimiterExtractor;

import calculator.constants.StringConst;
import calculator.delimiter.Delimiter;
import calculator.dto.DelimiterDto;

public class DefaultDelimiterExtractor implements DelimiterExtractor {


    public DelimiterDto extractDelimiter(String input) {
        Delimiter delimiter = new Delimiter(StringConst.DEFAULT_DELiMITER_REGEX);
        return delimiter.toDto();
    }


}