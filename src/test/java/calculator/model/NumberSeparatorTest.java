package calculator.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberSeparatorTest {

    @DisplayName("분리기는 숫자를 분리한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "4:5:6,7", "3,4", "//!\\n3!2,3"})
    void separateNumber(String validData) {
        assertDoesNotThrow(() -> NumberSeparator.from(validData).separate());
    }

    @DisplayName("분리기의 커스텀 구분자는 숫자가 될 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {"//3\\n", "//0\\n"})
    void isNotNumber(String invalidData) {
        assertThatThrownBy(() -> NumberSeparator.from(invalidData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DELIMITER_MUST_CHARACTER.getMessage());
    }

    @DisplayName("분리기의 커스텀 구분자는 공백, 길이가 2 이상인 문자열이 될 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {"//\\n", "//!@\\n", "//ab\\n", "//\t\\n"})
    void isCharacter(String invalidData) {
        assertThatThrownBy(() -> NumberSeparator.from(invalidData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DELIMITER_MUST_LENGTH_1.getMessage());
    }

    @DisplayName("분리기의 커스텀 구분자는 기본 구분자와 같을 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {"//,\\n", "//:\\n"})
    void isNotDefaultDelimiter(String invalidData) {
        assertThatThrownBy(() -> NumberSeparator.from(invalidData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_SEPARATOR_CUSTOM_DELIMITER_MUST_NOT_DEFAULT.getMessage());
    }

    // TODO: 에러 메세지 및 검증 추가
    @DisplayName("숫자 사이의 공백은 허용하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"1 2:3,4", "34\t2:2"})
    void isNotEmpty(String invalidData) {
        assertThrows(IllegalArgumentException.class, () -> NumberSeparator.from(invalidData).separate());
    }

    // TODO: 에러 메세지 및 검증 추가
    @DisplayName("분리기의 커스텀 구분자는 입력 문자열 맨 앞에 있어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1:2!3,4//!\\n", "1:2//!\\n!3", "1//!\\n!3!4"})
    void isForefront(String invalidData) {
        assertThrows(IllegalArgumentException.class, () -> NumberSeparator.from(invalidData).separate());
    }

    // TODO: 에러 메세지 및 검증 추가
    @DisplayName("문자열에 기본 구분자, 커스텀 구분자 외의 구분자가 올 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {"//!\\n1:2,3!4?5"})
    void isRegisteredDelimiter(String invalidData) {
        assertThrows(IllegalArgumentException.class, () -> NumberSeparator.from(invalidData).separate());
    }
}