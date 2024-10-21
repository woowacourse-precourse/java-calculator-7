package calculator.service;

import calculator.common.InputStatus;

public interface ValidatorService {

    /**
     * input을 검증한 후 InputStatus를 반환합니다.
     *
     * @param input 추출할 문자열
     * @return true or false
     * @throws IllegalArgumentException 잘못된 입력이 있을 경우 발생
     */
    InputStatus validateInput(String input) throws IllegalArgumentException;

    /**
     * 주어진 구분자와 표현식을 검증합니다.
     *
     * @param delimiter 검증할 구분자
     * @param expression 구분자에 대해 검증할 표현식
     * @throws IllegalArgumentException 구분자가 표현식에 대해 유효하지 않을 경우 발생
     */
    void validateDelimiterExpression(String delimiter, String expression) throws IllegalArgumentException;
}
