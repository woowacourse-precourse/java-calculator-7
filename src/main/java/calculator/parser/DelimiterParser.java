package calculator.parser;

import calculator.parser.delimiter.BasicDelimiterConstant;

import java.util.ArrayList;
import java.util.List;

import static calculator.parser.delimiter.CustomDelimiterPrefix.END;
import static calculator.parser.delimiter.CustomDelimiterPrefix.START;

public class DelimiterParser {

    public List<String> getBasicDelimiters() {
        return new ArrayList<>(BasicDelimiterConstant.BASIC_DELIMITERS);
    }

    public String getCustomDelimiter(String text) {
        if (text.indexOf(START.getPrefix()) != START.getStartIndex()) {
            return "";
        }

        if (text.indexOf(END.getPrefix()) != END.getStartIndex()) {
            return "";
        }

        return text.substring(START.getEndIndex(), END.getStartIndex());
    }

    public String replaceCustomDelimiterSyntax(String text, String customDelimiter) {
        return text.replace(String.join(customDelimiter, START.getPrefix(), END.getPrefix()), "");
    }
}
