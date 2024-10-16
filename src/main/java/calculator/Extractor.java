package calculator;

import java.util.Arrays;

public class Extractor {

    public int[] extractNumbers(String delimitedNumbers) {
        String delimiter = "[,:]";

        String[] splitNumbers = delimitedNumbers.split(delimiter);

        return Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).toArray();
    }

    // 검증된 값이 들어온다는 가정
    public String extractDelimiter(String delimitedNumbers) {
        String header = "//";
        String footer = "\\n";

        int beginIndex = delimitedNumbers.indexOf(header);
        int endIndex = delimitedNumbers.indexOf(footer);

        if (beginIndex == -1 || endIndex == -1) {
            return "";
        }
        return delimitedNumbers.substring(beginIndex + header.length(), endIndex);
    }
}
