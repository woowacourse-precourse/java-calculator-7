package calculator.handler;

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
        List<Integer> nums = handler.split(s);

        // then
        Assertions.assertThat(nums).hasSize(3);
        Assertions.assertThat(nums.get(0)).isEqualTo(1);
        Assertions.assertThat(nums.get(1)).isEqualTo(2);
        Assertions.assertThat(nums.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName(": 구분자를 사용하여 문자열을 나눈다.")
    void when_split_by_colon_then_return_list() {
        String s = "1:2:3";

        ColonSemicolonDelimiterHandler handler = new ColonSemicolonDelimiterHandler();
        List<Integer> nums = handler.split(s);

        Assertions.assertThat(nums).hasSize(3);
        Assertions.assertThat(nums.get(0)).isEqualTo(1);
        Assertions.assertThat(nums.get(1)).isEqualTo(2);
        Assertions.assertThat(nums.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName(",와 : 구분자를 사용하여 문자열을 나눈다.")
    void when_split_by_commaAndColon_then_return_list() {
        String s = "1:2:3,4";

        ColonSemicolonDelimiterHandler handler = new ColonSemicolonDelimiterHandler();
        List<Integer> nums = handler.split(s);

        Assertions.assertThat(nums).hasSize(4);
        Assertions.assertThat(nums.get(0)).isEqualTo(1);
        Assertions.assertThat(nums.get(1)).isEqualTo(2);
        Assertions.assertThat(nums.get(2)).isEqualTo(3);
        Assertions.assertThat(nums.get(3)).isEqualTo(4);
    }
}