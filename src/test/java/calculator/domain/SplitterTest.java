package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SplitterTest {

    @Test
    @DisplayName("구분자가 없을 때 기본 구분자로 분리 테스트")
    void testSplitWithoutCustomDelimiterSuccess() {
        // given
        String input = "123,21,3:4111";
        Splitter splitter = new Splitter();
        List<String> expected = List.of("123", "21", "3", "4111");

        // when
        List<String> actual = splitter.split(input);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(chars = {'[', ']', '-', '+', 'a', '0', '?', '/', '\\', '"', '\'', ';', '.', '<', '>', '!', '@', '#',
            '$', '%', '^', '&', '*', '(', ')', '='})
    @DisplayName("구분자가 있을 때 입력 구분자 포함 분리 테스트")
    void testSplitWithCustomDelimiterSuccess(char delimiter) {
        // given
        String input = String.format("//%c\\n123,21:3%c4111", delimiter, delimiter);
        Splitter splitter = new Splitter();
        List<String> expected = List.of("123", "21", "3", "4111");

        // when
        List<String> actual = splitter.split(input);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
