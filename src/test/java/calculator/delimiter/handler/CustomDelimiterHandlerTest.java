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
        assertThat(handler.isSupport("//;\\n")).isTrue();
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
        String s2 = "//7\\n47576";
        String s3 = "//-\\n4-5-6";
        String s4 = "//|\\n7";

        // when
        List<String> stringList1 = handler.split(s1);
        List<String> stringList2 = handler.split(s2);
        List<String> stringList3 = handler.split(s3);
        List<String> stringList4 = handler.split(s4);

        // then
        assertThat(stringList1).hasSize(3).containsExactly("1", "2", "3");
        assertThat(stringList2).hasSize(3).containsExactly("4", "5", "6");
        assertThat(stringList3).hasSize(3).containsExactly("4", "5", "6");
        assertThat(stringList4).hasSize(1).containsExactly("7");
    }

    @Test
    @DisplayName("커스텀 구분자 외에 다른 문자가 들어오면 IllegalException 예외가 발생한다.")
    void when_non_custom_delimiter_is_used_then_throw_illegal_argument_exception() {
        //given
        String s = "//|\\n1:2||3";

        // when, then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("형식이 일치하지 않습니다.");
    }

    @Test
    @DisplayName("//이 나오고 \\n이 나오지 않으면 IllegalException 예외가 발생한다.")
    void test1() {
        //given
        String s = "//|1:2|3";

        // when, then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("형식이 일치하지 않습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 두 개 이상의 문자를 가지면 IllegalException 예외가 발생한다.")
    void test2() {
        //given
        String s = "//||\\n1||2||3";

        // when, then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("형식이 일치하지 않습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 연속으로 나오면 IllegalException예외가 발생한다.")
    void test3() {
        //given
        String s = "//|\\n1||2|3";

        // when, then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("형식이 일치하지 않습니다.");
    }

}