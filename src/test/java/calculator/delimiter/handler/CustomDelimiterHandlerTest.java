package calculator.delimiter.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomDelimiterHandlerTest {
    @Test
    @DisplayName("커스텀 구분자를 반환한다.")
    void return_delimiter() {
        // given
        String s = "//;\\n1;2;3";
        CustomDelimiterHandler handler = new CustomDelimiterHandler();

        // when
        String delimiter = handler.extractDelimiter(s);

        // then
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자를 이용하여 문자열을 분리한다.")
    void when_split_by_customDelimiter_then_return_list() {
        // given
        String s = "//;\\n1;2;3";
        CustomDelimiterHandler handler = new CustomDelimiterHandler();

        // when
        List<String> stringList = handler.split(s);

        // then
        assertThat(stringList).hasSize(3)
                .containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("다양한 커스텀 구분자를 이용하여 문자열을 분리한다.")
    void when_split_by_customDelimiter_then_return_list2() {
        //given
        String s = "//||\\n1||2||3";
        CustomDelimiterHandler handler = new CustomDelimiterHandler();

        // when
        List<String> stringList = handler.split(s);

        // then
        assertThat(stringList).hasSize(3)
                .containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("음수가 입력되면 IllegalArgumentException을 발생시킨다.")
    void test() {
        // given
        String s = "//||\\n1||2||-3||4";

        // when
        CustomDelimiterHandler handler = new CustomDelimiterHandler();

        // then
        assertThatThrownBy(() -> handler.split(s))
                .isInstanceOf(IllegalArgumentException.class);
    }
}