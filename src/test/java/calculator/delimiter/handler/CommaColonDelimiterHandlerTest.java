package calculator.delimiter.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommaColonDelimiterHandlerTest {
    private CommaColonDelimiterHandler handler = new CommaColonDelimiterHandler();

    @Test
    @DisplayName("support() 메서드는 구분자로 ,와 :만 들어올 수 있다.")
    void when_delimiter_is_comma_or_colon_then_return_true() {
        assertThat(handler.supports(",,,")).isTrue();
        assertThat(handler.supports(":::")).isTrue();
        assertThat(handler.supports(",:")).isTrue();
        assertThat(handler.supports(",:;")).isFalse();
        assertThat(handler.supports("!@#$%^&*()")).isFalse();
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
    @DisplayName(",와 :구분자가 연속으로 나올 경우 IllegalArgumentException을 반환한다.")
    void throws_exception_when_delimiter_are_consecutive() {
        // given
        String s = "1,2,3,,4:5";

        // when, then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자가 연속해서 있습니다.");
    }

    @Test
    @DisplayName("구분자로 마지막에 끝나면 IllegalException예외가 발생한다.")
    void throw_illegalException_when_string_ends_with_commaColon_delimiter() {
        // given
        String s = "1,4:";

        // when, then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자로 문자열이 끝납니다.");
    }
}