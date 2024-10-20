package calculator.model;

import calculator.controller.DelimiterController;
import calculator.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("연산부분 테스트")
class ArithmeticTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3!4","a1,2:3","1,가,2,3"})
    @DisplayName("기본 구분자를 사용할 때 숫자와 기본구분자 이외의 문자가 있으면 예외가 발생한다")
    void isInvalidCalculatorWithDefaultDelimiter(String input){
        InputData inputData = new InputData(input);
        assertThatThrownBy(()->new Arithmetic(new DefaultDelimiter(),inputData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_DATA_WITH_DEFAULT_DELIMITER_FORMAT.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,","1:2:3","1:2,3"})
    @DisplayName("기본 구분자를 사용할 때 숫자와 기본구분자만 있으면 예외가 발생하지 않는다")
    void isValidCalculatorWithDefaultDelimiter(String input){
        InputData inputData = new InputData(input);
        assertThatCode(()->new Arithmetic
                (new DefaultDelimiter(), inputData))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4","1:2:3:4","1,2:3,4","1:2:3,4"})
    @DisplayName("기본 구분자를 사용해서 연산 부분의 숫자를 낱개로 분리한다")
    void splitCalculatorPartWithDefaultDelimiter(String input) {
        InputData inputData = new InputData(input);
        assertThat(new Arithmetic(new DefaultDelimiter(), inputData).getArithmetic()).isEqualTo(List.of(1,2,3,4));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3;4","//.;\\n1.2;3.4","//^?!\\n1^2?3!4"})
    @DisplayName("커스텀 구분자를 사용해서 연산 부분의 숫자를 낱개로 분리한다")
    void splitCalculatorPartWithCustomDelimiter(String input) {
        InputData inputData = new InputData(input);
        assertThat(new Arithmetic
                (new CustomDelimiter(inputData.convertDelimiterPart()), inputData)
                .getArithmetic()).isEqualTo(List.of(1,2,3,4));
    }
}