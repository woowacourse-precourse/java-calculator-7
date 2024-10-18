package calculator.model;

import calculator.common.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class UserInput {
    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    protected static final String REGEX_DELIMITER = "|";

    protected final List<String> delimiters;
    protected long[] inputNumbers;

    protected UserInput(String userInput) {
        delimiters = new ArrayList<>();
        delimiters.add(DEFAULT_DELIMITER_COMMA);
        delimiters.add(DEFAULT_DELIMITER_COLON);

        parseInputForCalculate(userInput);
    }

    /***
     * 사용자의 정상 입력에 대한 합을 계산합니다.
     * @return : 덧셈 계산기 실행 결과
     */
    public long sumCalculate() {
        return Arrays.stream(inputNumbers).sum();
    }

    /***
     * 계산하기 위해 입력된 문자열을 파싱합니다.
     * @param userInput : 사용자의 입력
     */
    protected abstract void parseInputForCalculate(String userInput);

    /***
     * 계산할 부분을 구분자를 통해 나눕니다.
     * @param calculatePart : 계산해야 할 문자열
     * @return : 구분자로 split 된 string[] 배열
     */
    protected abstract String[] splitCalculatePartByDelimiters(String calculatePart);

    /***
     * 계산할 값이 양수인지 체크합니다.
     * @param num : 파싱된 값
     * @return : 양수면 true 리턴, 음수면 예외 출력
     */
    protected boolean checkNumIsPositive(Long num) {
        if (num < 0) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_POSITIVE.getValue());
        }
        return true;
    }

}
