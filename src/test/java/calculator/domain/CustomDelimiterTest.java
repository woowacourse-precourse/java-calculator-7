package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CustomDelimiterTest {

    @Test
    @DisplayName("CustomDelimiter는_길이_1의_문자열을_입력받아_생성될_수_있다")
    public void create() {
        //given
        //when
        CustomDelimiter result = new CustomDelimiter("t");

        //then
        assertThat(result.getValue()).isEqualTo("t");
    }

    @Test
    @DisplayName("CustomDelimiter는_길이_1이_아닌_문자열을_입력받아_생성되면_예외를_던진다")
    public void LengthException() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new CustomDelimiter("test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 길이 1의 문자여야합니다");
    }
}