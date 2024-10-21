package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//"; // 커스텀 구분자 접두사
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public String[] parseNumbers(String input) {
        List<String> delimiterList = new ArrayList<>(Arrays.asList(",", ":"));
        String numbersPart = input; // 숫자 부분

        if (isEndsWithNumber(input)) {
            throw new IllegalArgumentException("구분자 뒤에 숫자가 없습니다: " + input);
        }

        if (input.startsWith("//")) {
            int delimiterEndIndex = numbersPart.indexOf(CUSTOM_DELIMITER_SUFFIX);
            int numbersStartIndex = delimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length();

            if (isCustomDelimiterSuffixMissing(delimiterEndIndex)) {
                throw new IllegalArgumentException("\\n이 존재하지 않습니다: " + input);
            } else if (isCustomDelimiterMissing(delimiterEndIndex)) {
                throw new IllegalArgumentException("커스텀 구분자가 지정되지 않았습니다: " + input);
            }

            if (hasNoNumber(input, numbersStartIndex)) {
                return new String[]{};
            }

            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);

            delimiterList.add(customDelimiter);
            numbersPart = input.substring(numbersStartIndex);
        }

        String delimiter = String.join("|", delimiterList);
        return numbersPart.split(delimiter);
    }

    private boolean isEndsWithNumber(String input) {
        return !Character.isDigit(input.charAt(input.length() - 1));
    }

    private boolean isCustomDelimiterSuffixMissing(int delimiterEndIndex) {
        // \n이 존재하지 않는 경우
        return delimiterEndIndex == -1;
    }

    private boolean isCustomDelimiterMissing(int delimiterEndIndex) {
        // "//"와 "\n"사이에 커스텀 구분자가 지정되지 않은 경우
        return delimiterEndIndex == 2;
    }

    private boolean hasNoNumber(String input, int numbersStartIndex) {
        // 커스텀 구분자만 지정하고 숫자가 없는 경우(ex. "//;\\n")
        return input.length() <= numbersStartIndex;
    }
}
