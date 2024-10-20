package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 구분자 객체
 */
public class CalculatorDelimiter {
    private final List<String> delimiterList;

    public String getDelimiterRegex() {
        StringBuilder regex = new StringBuilder();
        for (int idx = 0; idx < delimiterList.size(); idx++) {
            if (idx == delimiterList.size() - 1) {
                regex.append(delimiterList.get(idx));
                continue;
            }
            regex.append(delimiterList.get(idx)).append("|");
        }
        return regex.toString();
    }

    public void addDelimiter(String delimiter) {
        String quote = Pattern.quote(delimiter);
        delimiterList.add(quote);
    }

    public CalculatorDelimiter() {
        delimiterList = new ArrayList<>();
        delimiterList.add(",");
        delimiterList.add(":");
    }
}
