package calculator.operation;

import java.util.List;

public class StringAdditionCalculator {
    private final String DELIMITER_START = "//";
    private final String DELIMITER_END = "\\n";

    private List<String> delimiters;

    private String numberString;

    public StringAdditionCalculator(String numberString) {
        this.numberString = numberString;
    }

    public int calculateSum() {
        return 0;
    }

    /**
     * 커스텀 구분자 추출
     */
    private void extractCustomDelimiter() {
        if (!numberString.startsWith(DELIMITER_START)) {
            return;
        }

        int startIdx = numberString.indexOf(DELIMITER_START);
        int endIdx = numberString.indexOf(DELIMITER_END);

        // 커스텀 구분자 추출
        String customDelimiter = numberString.substring(startIdx + DELIMITER_START.length(), endIdx);
        numberString = numberString.substring(endIdx + DELIMITER_END.length());

        // 구분자 리스트에 추가
        delimiters.add(customDelimiter);

        // 추출되지 않은 커스텀 구분자가 남아있으면 추출 (recursive)
        this.extractCustomDelimiter();
    }
}
