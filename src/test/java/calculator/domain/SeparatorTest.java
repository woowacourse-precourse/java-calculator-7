package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SeparatorTest {

    @DisplayName("구분자 입력 실패 : 여러 자 입력")
    @ParameterizedTest
    @ValueSource(strings = {"//;;\\n"})
    void validateLengthTest(String inputs) {
        //given

        //when, then
        assertThatThrownBy(() -> new Separator(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 한 자만 가능합니다.");
    }

    @DisplayName("구분자 입력 실패 : 숫자 입력")
    @ParameterizedTest
    @ValueSource(strings = {"//3\\n"})
    void validateLetterTest(String inputs) {
        //given

        //when, then
        assertThatThrownBy(() -> new Separator(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 문자만 가능합니다.");
    }
}
