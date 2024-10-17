package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class UserInput {
    protected final List<String> delimiters;
    protected long[] inputNumbers;

    protected UserInput(String userInput) {
        delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        parseInputForCalculate(userInput);
        checkInputNumsIsPositive();
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
     * 계산해야 할 값이 숫자로만 이루어져있는지 확인합니다.
     * @param splitStringByDelimiter : 구분자에 의해 split 된 배열
     */
    protected void checkValueToCalculateIsNumber(String[] splitStringByDelimiter) {
        try {
            Arrays.stream(splitStringByDelimiter).forEach(Long::parseLong);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자(, 또는 :)와 숫자로만 입력해주세요.");
        }
    }

    /***
     * 계산할 값들이 양수로만 이루어져있는지 확인합니다.
     */
    private void checkInputNumsIsPositive() {
        if (Arrays.stream(this.inputNumbers).anyMatch(inputNumber -> inputNumber < 0)) {
            throw new IllegalArgumentException("양수만 입력해주세요.");
        }
    }

}
