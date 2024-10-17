package calculator.delimiter.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ColonSemicolonDelimiterHandlerTest {
    private ColonSemicolonDelimiterHandler handler = new ColonSemicolonDelimiterHandler();

    @Test
    @DisplayName("support() 메서드는 구분자로 ,와 :만 들어올 수 있다.")
    void when_delimiter_is_comma_or_colon_then_return_true() {
        assertThat(handler.isSupport(",,,")).isTrue();
        assertThat(handler.isSupport(":::")).isTrue();
        assertThat(handler.isSupport(",:")).isTrue();
        assertThat(handler.isSupport(",:;")).isFalse();
        assertThat(handler.isSupport("!@#$%^&*()")).isFalse();
    }

    @Test
    @DisplayName(",와 :구분자를 사용하여 나눈 문자열을 문자열 리스트로 반환한다.")
    void returns_string_list_by_splitting_using_comma_and_colon_delimiters() {
        // given
        String s = "1,2,3,4:5";

        // when
        List<String> stringList = handler.split(s);

        // then
        assertThat(stringList).hasSize(5).containsExactly("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("음수가 입력되면 IllegalArgumentException을 발생시킨다.")
    void test() {
        // given
        String s = "1:2:-3,4";

        // when, then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class);
    }
}