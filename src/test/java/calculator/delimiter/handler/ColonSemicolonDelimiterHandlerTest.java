package calculator.delimiter.handler;

import calculator.delimiter.handler.impl.ColonSemicolonDelimiterHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ColonSemicolonDelimiterHandlerTest {
    @Test
    @DisplayName(", 구분자를 사용하여 문자열을 나눈다.")
    void when_split_by_comma_then_return_list() {
        // given
        String s = "1,2,3";
        ColonSemicolonDelimiterHandler handler = new ColonSemicolonDelimiterHandler();

        // when
        List<String> stringList = handler.split(s);

        // then
        Assertions.assertThat(stringList).hasSize(3)
                .containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName(": 구분자를 사용하여 문자열을 나눈다.")
    void when_split_by_colon_then_return_list() {
        String s = "1:2:3";

        ColonSemicolonDelimiterHandler handler = new ColonSemicolonDelimiterHandler();
        List<String> stringList = handler.split(s);

        Assertions.assertThat(stringList).hasSize(3)
                .containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName(",와 : 구분자를 사용하여 문자열을 나눈다.")
    void when_split_by_commaAndColon_then_return_list() {
        String s = "1:2:3,4";

        ColonSemicolonDelimiterHandler handler = new ColonSemicolonDelimiterHandler();
        List<String> stringList = handler.split(s);

        Assertions.assertThat(stringList).hasSize(4)
                .containsExactly("1", "2", "3", "4");
    }
}