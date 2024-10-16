package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사용자 입력 객체 테스트")
class InputDataTest {
    private InputData inputData;

    @BeforeEach
    void setUp() {
        inputData = new InputData("test");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123!","0721가","2038a"})
    @DisplayName("마지막 입력 값이 숫자가 아니면 예외가 발생한다")
    void checkLastInputIsNotDigit(String input){
        assertThatThrownBy(()->inputData.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123!1","0721가2","2038a3"})
    @DisplayName("마지막 입력 값이 숫자이면 예외가 발생하지 않는다")
    void checkLastInputIsDigit(String input){
        assertThatCode(()->inputData.validate(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {",123","가0721","a2038"})
    @DisplayName("입력 값의 처음이 / 나 숫자가 아니면 예외가 발생한다")
    void checkStartInputIsInvalid(String input){
        assertThatThrownBy(()->inputData.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/,123","1가0721","/!/a2038"})
    @DisplayName("입력 값의 처음이 / 나 숫자라면 예외가 발생하지 않는다")
    void checkStartInputIsValid(String input){
        assertThatCode(()->inputData.validate(input))
                .doesNotThrowAnyException();
    }
}