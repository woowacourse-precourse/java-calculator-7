package calculator.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomDelimiterHandlerTest {
    @Test
    @DisplayName("커스텀 구분자를 반환한다.")
    void return_delimiter() {
        String s = "//;\n1;2;3";
        CustomDelimiterHandler handler = new CustomDelimiterHandler();

        String delimiter = handler.extractDelimiter(s);
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자를 이용하여 문자열을 분리한다.")
    void when_split_by_customDelimiter_then_return_list() {
        String s = "//;\n1;2;3";
        CustomDelimiterHandler handler = new CustomDelimiterHandler();

        List<Integer> integerList = handler.split(s);

        assertThat(integerList).hasSize(3);
        assertThat(integerList.get(0)).isEqualTo(1);
        assertThat(integerList.get(1)).isEqualTo(2);
        assertThat(integerList.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("다양한 커스텀 구분자를 이용하여 문자열을 분리한다.")
    void when_split_by_customDelimiter_then_return_list2() {
        String s = "//||\n1||2||3";
        CustomDelimiterHandler handler = new CustomDelimiterHandler();

        List<Integer> integerList = handler.split(s);

        assertThat(integerList).hasSize(3);
        assertThat(integerList.get(0)).isEqualTo(1);
        assertThat(integerList.get(1)).isEqualTo(2);
        assertThat(integerList.get(2)).isEqualTo(3);
    }
}