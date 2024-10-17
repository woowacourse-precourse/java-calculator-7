package calculator.delimiter.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomDelimiterHandlerTest {
    private CustomDelimiterHandler handler = new CustomDelimiterHandler();

    @Test
    @DisplayName("//와 \n 사이에 하나 이상의 구분자 문자가 포함되어야 한다.")
    void when_custom_delimiter_is_between_double_slash_and_newline_then_support_is_true() {
        assertThat(handler.isSupport("//;\\n1;2;3")).isTrue();
        assertThat(handler.isSupport("//;\\n1")).isTrue();
        assertThat(handler.isSupport("//;\\n")).isFalse();
        assertThat(handler.isSupport("//\\n")).isFalse();
        assertThat(handler.isSupport("")).isFalse();
    }

    @Test
    @DisplayName("커스텀 구분자를 반환한다.")
    void return_custom_delimiter() {
        // given
        String s1 = "//;\\n";
        String s2 = "//&\\n";
        String s3 = "//:\\n";

        // when
        String delimiter1 = handler.extractDelimiter(s1);
        String delimiter2 = handler.extractDelimiter(s2);
        String delimiter3 = handler.extractDelimiter(s3);

        // then
        assertThat(delimiter1).isEqualTo(";");
        assertThat(delimiter2).isEqualTo("&");
        assertThat(delimiter3).isEqualTo(":");
    }

    @Test
    @DisplayName("커스텀 구분자만을 이용하여 문자열을 분리해야 한다.")
    void return_list_when_split_by_custom_delimiter() {
        // given
        String s1 = "//;\\n1;2;3";
        String s2 = "//||\\n4||5||6";
        String s3 = "//||\\n7";

        // when
        List<String> stringList1 = handler.split(s1);
        List<String> stringList2 = handler.split(s2);
        List<String> stringList3 = handler.split(s3);

        // then
        assertThat(stringList1).hasSize(3).containsExactly("1", "2", "3");
        assertThat(stringList2).hasSize(3).containsExactly("4", "5", "6");
        assertThat(stringList3).hasSize(1).containsExactly("7");
    }

    @Test
    @DisplayName("커스텀 구분자 외에 다른 문자가 들어오면 IllegalException 예외가 발생한다.")
    void when_non_custom_delimiter_is_used_then_throw_illegal_argument_exception() {
        //given
        String s = "//||\\n1:2||3";

        // when, then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("형식이 일치하지 않습니다.");
    }

    @Test
    @DisplayName("음수가 입력되면 IllegalArgumentException을 발생시킨다.")
    void when_negative_number_is_input_then_throw_illegal_argument_exception() {
        // given
        String s = "//||\\n1||2||-3||4";

        // when, then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수가 포함되어 있습니다.");
    }
}