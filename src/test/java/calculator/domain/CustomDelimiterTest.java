package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomDelimiterTest {

    @ParameterizedTest
    @DisplayName("CustomDelimiter는_null_또는_길이_1의_문자로_생성될_수_있다")
    @NullSource
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
    @CsvSource({"d,true", ",false"})
    @DisplayName("CustomDelimiter는_값의_존재_여부를_반환할_수_있다")
    public void isValueExist(String input, boolean expected) {
        //given
        //when
        CustomDelimiter result = new CustomDelimiter(input);

        //then
        assertThat(result.isValueExist())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("CustomDelimiter는_길이_1이_아닌_문자열을_입력받아_생성되면_예외를_던진다")
    @EmptySource
    @ValueSource(strings = {"  ", "test", "22", "--"})
    public void LengthException(String input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new CustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("커스텀 구분자는 한 문자여야합니다");
    }

}