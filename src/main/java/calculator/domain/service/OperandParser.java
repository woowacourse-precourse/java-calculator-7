package calculator.domain.service;

import calculator.domain.dto.DelimiterParserResult;
import java.util.ArrayList;

public class OperandParser {

    public String[] parsingOperands(DelimiterParserResult delimParserResult) {
        ArrayList delimiters = delimParserResult.getDelimiters();
        String removedString = delimParserResult.getRemovedString();

        String delimiterRegex = String.join("|", delimiters);
        return removedString.split(delimiterRegex);
    }
}
