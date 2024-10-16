package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExceptionHandlerTest {
    ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();

    @ParameterizedTest
    @DisplayName("커스텀 구분자 생성시 슬래시(/)와 역슬래시(\\) 그리고 n 이외의 문자가 들어오면 예외 발생한다.")
    @ValueSource(chars = {'{', '}', '|'})
    void checkIncorrectDelimGenerateInputThrowException(char elem) {
        assertThatThrownBy(() -> exceptionHandler.checkIncorrectDelimGenerateInput(elem)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자 생성시 슬래시(/)와 역슬래시(\\) 그리고 n이 들어올 경우 예외가 발생하지 않는다.")
    @ValueSource(chars = {'/', '\\', 'n'})
    void checkIncorrectDelimGenerateInputNotThrowException(char elem) {
        assertThatCode(() -> exceptionHandler.checkIncorrectDelimGenerateInput(elem)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("입력된 문자열에 쉼표와 콜론 음수 부호와 정수 외의 문자가 들어가 있을 경우 예외가 발생한다.")
    @ValueSource(strings = {"1|2:3", "1,2}3", "1(2)3"})
    void checkIncorrectInputWithoutCustomDelimThrowException(String input) {
        char[] splitInput = input.toCharArray();
        assertThatThrownBy(() -> exceptionHandler.checkIncorrectInputWithoutCustomDelim(splitInput)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력된 문자열에 쉼표와 콜론 음수 부호와 정수 외의 문자가 들어가 있지 않을 경우 예외가 발생하지 않는다.")
    @ValueSource(strings = {"1:2:3", "1,2,3", "1:2,3", "1,2:3"})
    void checkIncorrectInputWithoutCustomDelimNotThrowException() {
        char[] input = "1,2:3".toCharArray();
        assertThatCode(() -> exceptionHandler.checkIncorrectInputWithoutCustomDelim(input)).doesNotThrowAnyException();
    }
}