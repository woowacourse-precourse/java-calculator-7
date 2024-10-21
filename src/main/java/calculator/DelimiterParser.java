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

        if (!Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException("구분자 뒤에 숫자가 없습니다.");
        }

        if (input.startsWith("//")) {
            int delimiterEndIndex = numbersPart.indexOf(CUSTOM_DELIMITER_SUFFIX);
            int numbersStartIndex = delimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length();

            // \n이 존재하지 않거나 //와 \n사이에 구분자가 없는 경우
            if (delimiterEndIndex == -1 || delimiterEndIndex == 2) {
                throw new IllegalArgumentException("잘못된 입력값입니다: " + input);
            }

            // 커스텀 구분자만 지정하고 숫자가 없는 경우(ex. "//;\\n")
            if (input.length() < numbersStartIndex) {
                return new String[]{};
            }

            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);

            delimiterList.add(customDelimiter);
            numbersPart = input.substring(numbersStartIndex);
        }

        String delimiter = String.join("|", delimiterList);
        return numbersPart.split(delimiter);
    }
}
