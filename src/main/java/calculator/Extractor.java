package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Extractor {

    private static final String header = "//";
    private static final String footer = "\n";
    private static final String defaultDelimiter = "[,:]";

    // numbersWithDelimiter 에는 "1;2;3" 와 같이 사용자의 입력이 그대로 들어옴
    public int[] extractNumbers(String delimitedNumbers, String delimiter) {
        String regexDelimiter = makeRegexDelimiter(delimiter);
        String[] splitNumbers = delimitedNumbers.split(regexDelimiter);

        return Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).toArray();
    }

    // 검증된 값이 들어온다는 가정
    public String extractDelimiter(String delimitedNumbers) {
        int beginIndex = delimitedNumbers.indexOf(header);
        int endIndex = delimitedNumbers.indexOf(footer);

        if (beginIndex == -1 || endIndex == -1) {
            return "";
        }
        return delimitedNumbers.substring(beginIndex + header.length(), endIndex);
    }

    private String makeRegexDelimiter(String delimiter) {
        return delimiter.isEmpty() ? defaultDelimiter : Pattern.quote(delimiter);
    }
}
