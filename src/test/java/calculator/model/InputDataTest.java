package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사용자 입력 객체 테스트")
class InputDataTest {

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3;!","0,7,2,1,가","2,0,3,8,a"})
    @DisplayName("마지막 입력 값이 숫자가 아니면 예외가 발생한다")
    void checkLastInputIsNotDigit(String input){
        InputData inputData = new InputData(input);
        assertThatThrownBy(()->inputData.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[F0001]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3","0,7,2,1","2,0,3,8"})
    @DisplayName("마지막 입력 값이 숫자이면 예외가 발생하지 않는다")
    void checkLastInputIsDigit(String input){
        InputData inputData = new InputData(input);
        assertThatCode(()->inputData.validate(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2,3","가,0,7,2,1","a,20,38"})
    @DisplayName("커스텀 구분자가 없고 입력 값의 처음이 숫자가 아니면 예외가 발생한다")
    void checkInputStartsWithoutCustomDelimiterIsInvalid(String input){
        InputData inputData = new InputData(input);
        assertThatThrownBy(()->inputData.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[F0002]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,23","1,7,21","2,20,38"})
    @DisplayName("커스텀 구분자가 없고 입력 값의 처음이 숫자라면 예외가 발생하지 않는다")
    void checkInputStartsWithoutCustomDelimiterIsValid(String input){
        InputData inputData = new InputData(input);
        assertThatCode(()->inputData.validate(input))
                .doesNotThrowAnyException();
    }

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

}