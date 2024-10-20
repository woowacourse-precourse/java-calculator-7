package calculator.domain.delimiter_input;

import calculator.Input;

/**
 * DefaultDelimiterInput 클래스는 기본 구분자(쉼표와 콜론)를 사용하는 입력 문자열을 처리하는 클래스입니다.
 */
public class DefaultDelimiterInput extends DelimiterInput {

    /**
     * DefaultDelimiterInput 생성자입니다. 기본 구분자를 사용하여 DelimiterInput을 초기화합니다.
     *
     * @param input 사용자로부터 입력받은 계산할 문자열을 포함하는 Input 객체
     */
    public DefaultDelimiterInput(Input input) {
        super(String.format(DELIMITER_PATTERN_TEMPLATE, ""), input.input());
    }
}
