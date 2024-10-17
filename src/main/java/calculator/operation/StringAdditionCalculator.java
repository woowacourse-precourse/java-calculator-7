package calculator.operation;

import calculator.operation.constants.BasicDelimiter;

import java.util.ArrayList;
import java.util.Arrays;
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
        return this.getSum();
    }

    /**
     * 합계 구하기
     */
    private int getSum() {
        // 최종 구분자
        String finalDelimiter = getFinalDelimiter();
        // 합계 반환
        return Arrays.stream(numberString.split(finalDelimiter)).mapToInt(Integer::parseInt).sum();
    }

    /**
     * 최종 구분자 생성
     */
    private String getFinalDelimiter() {
        // 기본 구분자 리스트
        List<String> basicDelimiters = Arrays.stream(BasicDelimiter.values())
                .map(BasicDelimiter::getDelimiter)
                .toList();

        // 커스텀 구분자 추가 가능한 리스트
        delimiters = new ArrayList<>(basicDelimiters);

        // 커스텀 구분자 추출 (recursive)
        this.extractCustomDelimiter();

        // 최종 구분자 반환
        return String.join("|", delimiters);
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
