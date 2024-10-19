package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberExtractor {

    private static final String NUMBER_REGEX = "([0-9])+";
    private List<Integer> extractedNumbers;

    public NumberExtractor(String rawString) {
        this.extractedNumbers = new ArrayList<>();
    }

    public List<Integer> getExtractedNumbers() {
        return extractedNumbers;
    }

    private void extractNumbers(String rawString) {
        Matcher matcher = Pattern.compile(NUMBER_REGEX).matcher(rawString);

        while (matcher.find()) {
            extractedNumbers.add(Integer.valueOf(matcher.group()));
        }
    }
}
