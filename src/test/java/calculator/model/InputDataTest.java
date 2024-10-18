package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사용자 입력 객체 테스트")
class InputDataTest {
    @Test
    @DisplayName("커스텀 구분자를 입력했을 때 True 값을 반환한다")
    void isDelimiterTrueWhenContainPattern(){
        InputData inputData = new InputData("//;.!\\n1;2.3!4");
        assertThat(inputData.isDelimiter()).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자를 입력하지 않았을 때 False 값을 반환한다")
    void isDelimiterFalseWhenNotContainsPattern(){
        InputData inputData = new InputData("1:2,3,4:5");
        assertThat(inputData.isDelimiter()).isFalse();
    }

    @Test
    @DisplayName("커스텀 구분자를 입력했을 때 구분자를 잘 분리한다")
    void splitDelimiterExactly(){
        InputData inputData = new InputData("//;.!\\n1;2.3!4");
        assertThat(inputData.convertDelimiterPart()).isEqualTo(";.!");
    }

    @Test
    @DisplayName("커스텀 구분자를 입력했을 때 연산부분을 잘 분리한다")
    void splitCalculatorExactly(){
        InputData inputData = new InputData("//;.!\\n1;2.3!4");
        assertThat(inputData.convertCalculatorPart()).isEqualTo("1;2.3!4");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3!4","a1,2:3","1,가,2,3"})
    @DisplayName("기본 구분자를 사용할 때 숫자와 기본구분자 이외의 문자가 있으면 예외가 발생한다")
    void isInvalidCalculatorWithDefaultDelimiter(){
        assertThatThrownBy(()->new InputData("1,2,3!4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[F0001]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,",":1:2:3","1:2,3"})
    @DisplayName("기본 구분자를 사용할 때 숫자와 기본구분자만 있으면 예외가 발생하지 않는다")
    void isValidCalculatorWithDefaultDelimiter(String input){
        assertThatCode(()->new InputData(input))
                .doesNotThrowAnyException();
    }

}