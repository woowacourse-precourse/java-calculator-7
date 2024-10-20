package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CustomDelimiterTest {

    @ParameterizedTest
    @DisplayName("CustomDelimiter는_길이_1의_문자열을_입력받아_생성될_수_있다")
    @ValueSource(strings = {"t", " ", "1", "-"})
    public void create(String input) {
        //given
        //when
        CustomDelimiter result = new CustomDelimiter(input);

        //then
        assertThat(result.getValue())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @DisplayName("CustomDelimiter는_길이_1이_아닌_문자열을_입력받아_생성되면_예외를_던진다")
    @ValueSource(strings = {"", "  ", "test", "22", "--"})
    public void LengthException(String input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new CustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("구분자는 길이 1의 문자여야합니다");
    }
}