package calculator.delimiter.handler;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NoDelimiterHandlerTest {
    private NoDelimiterHandler handler = new NoDelimiterHandler();

    @Test
    @DisplayName("비어있는 문자열이 들어올 경우 0을 반환한다.")
    void calculate_sum_with_empty_string() {
        // given
        String str = "";

        // when
        List<String> stringList = handler.split(str);

        // then
        assertThat(handler.isSupport(str)).isTrue();
        assertThat(stringList.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("구분자 없이 숫자만 들어올 경우 숫자를 출력한다.")
    void calculate_sum_with_no_delimiter() {
        // given
        String str = "1234";

        // when
        List<String> stringList = handler.split(str);

        // then
        assertThat(handler.isSupport(str)).isTrue();
        assertThat(stringList).hasSize(1)
                .containsExactly("1234");
    }

    @Test
    @DisplayName("구분자 없는 문자열에 음수가 포함될 경우 해당 핸들러에서 처리하지 않는다.")
    void throws_error_when_string_has_negative() {
        // given
        String str1 = "-1234";
        String str2 = "//-\\n1234";
        String str3 = "//-\\n1-2-3-4";

        // when, then
        assertThat(handler.isSupport(str1)).isFalse();
        assertThat(handler.isSupport(str2)).isFalse();
        assertThat(handler.isSupport(str3)).isFalse();
    }
}