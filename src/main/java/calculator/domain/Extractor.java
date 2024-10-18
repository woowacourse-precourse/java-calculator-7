package calculator.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Extractor {

    private static final String HEADER = "//";
    private static final String FOOTER = "\\n";
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int NUMBER_BEGIN_INDEX = 5;

    public int[] makeNumberArray(String numsWithDelimiter, String delimiter) {
        String nums = extractNumbers(numsWithDelimiter, delimiter);
        String regexDelimiter = makeRegexDelimiter(delimiter);

        String[] splitNumbers = nums.split(regexDelimiter);

        return Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).toArray();
    }

    // 검증된 값이 들어온다는 가정
    public String extractDelimiter(String delimitedNumbers) {
        int beginIndex = delimitedNumbers.indexOf(HEADER);
        int endIndex = delimitedNumbers.indexOf(FOOTER);

        if (beginIndex == -1 || endIndex == -1) {
            return "";
        }
        return delimitedNumbers.substring(beginIndex + HEADER.length(), endIndex);
    }

    private String makeRegexDelimiter(String delimiter) {
        return delimiter.isEmpty() ? DEFAULT_DELIMITER : Pattern.quote(delimiter);
    }

    private String extractNumbers(String numsWithDelimiter, String delimiter) {
        if (delimiter.isEmpty()) {
            return numsWithDelimiter;
        }
        return numsWithDelimiter.substring(NUMBER_BEGIN_INDEX);
    }
}
