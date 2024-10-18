package calculator.service;

import static calculator.util.Const.EMPTY;
import static calculator.util.Const.PREFIX;
import static calculator.util.Const.PREFIX_ERROR_MESSAGE;
import static calculator.util.Const.PREFIX_SIZE;
import static calculator.util.Const.SUFFIX;

import calculator.domain.DelimiterSet;
import java.util.List;

public class DelimiterExtractor {
    
    public DelimiterSet extractDelimiter(String input) {
        DelimiterSet delimiterSet = new DelimiterSet();
        if (!input.startsWith(PREFIX)) {
            return delimiterSet;
        }
        String firstHalf = getFistHalf(input);
        String[] delimiters = firstHalf.split(EMPTY);
        delimiterSet.addAll(List.of(delimiters));
        return delimiterSet;
    }

    private String getFistHalf(String input) {
        int indexOfSplitDelimiter = input.indexOf(SUFFIX);
        if (indexOfSplitDelimiter == -1) {
            return EMPTY;
        }
        if (!input.startsWith(PREFIX)) {
            throw new IllegalArgumentException(PREFIX_ERROR_MESSAGE);
        }
        return input.substring(PREFIX_SIZE, indexOfSplitDelimiter);
    }
}
