package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SeparatorTest {

    @DisplayName("구분자 입력 성공")
    @ParameterizedTest
    @ValueSource(strings = {"//;\\n", "//(\\n"})
    void separatorTest(String inputs) {
        //given
        //when, then
        assertThatCode(() -> new Separator(inputs)).doesNotThrowAnyException();
    }

    @DisplayName("구분자 입력 실패 : 여러 자 입력, 빈 값 입력")
    @ParameterizedTest
    @ValueSource(strings = {"//;;\\n", "//\\n"})
    void validateLengthTest(String inputs) {
        //given

        //when, then
        assertThatThrownBy(() -> new Separator(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 한 자만 가능합니다.");
    }

    @DisplayName("구분자 입력 실패 : 숫자 입력")
    @ParameterizedTest
    @ValueSource(strings = {"//1\\n"})
    void validateLetterTest(String inputs) {
        //given

        //when, then
        assertThatThrownBy(() -> new Separator(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 문자만 가능합니다.");
    }

    @DisplayName("문자열 분리 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "//;\\n1;2;3"})
    void splitBySeparatorTest(String inputs) {
        //given

        //when
        Separator separator = new Separator(inputs);
        String[] splitValue = separator.splitBySeparator(inputs);

        //then
        assertThat(splitValue).isEqualTo(new String[]{"1", "2", "3"});
    }
}
