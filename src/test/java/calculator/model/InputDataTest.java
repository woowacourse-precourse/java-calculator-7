package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void checkLastInput(String input){
        assertThatThrownBy(()->inputData.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {",123","가0721","a2038"})
    @DisplayName("입력 값의 처음이 / 나 숫자가 아니면 예외가 발생한다")
    void checkStartInput(String input){
        assertThatThrownBy(()->inputData.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}