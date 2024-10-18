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

        if (notStartWithPrefix(input)) {
            return new DelimiterSet();
        }

        DelimiterSet delimiterSet = new DelimiterSet();
        String firstHalf = getFistHalf(input);
        delimiterSet.addAll(List.of(firstHalf.split(EMPTY)));
        return delimiterSet;
    }

    private String getFistHalf(String input) {
        int indexOfSplitDelimiter = input.indexOf(SUFFIX);
        if (indexOfSplitDelimiter == -1) {
            return EMPTY;
        }
        checkValidatePrefix(input);
        return input.substring(PREFIX_SIZE, indexOfSplitDelimiter);
    }

    private boolean notStartWithPrefix(String input) {
        return !input.startsWith(PREFIX);
    }

    private void checkValidatePrefix(String input) {
        if (notStartWithPrefix(input)) {
            throw new IllegalArgumentException(PREFIX_ERROR_MESSAGE);
        }
    }
}
