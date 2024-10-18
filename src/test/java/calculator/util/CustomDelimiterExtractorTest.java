package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.exception.util.CustomDelimiterExtractorErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomDelimiterExtractorTest {

    @Test
    @DisplayName("올바른 형태의 커스텀 구분자")
    void 올바른_커스텀_구분자() {
        // given
        String input = "//;\\n1;2;3";

        // when
        String delimiter = CustomDelimiterExtractor.extract(input);

        // then
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자 형식이 잘못된 경우 예외 처리")
    void 잘못된_형식의_커스텀_구분자() {
        // given
        String input = "//;;3,4";

        // when & then
        assertThatThrownBy(() -> CustomDelimiterExtractor.extract(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자가 기본 구분자와 같을 때 예외 처리")
    void 기본_구분자와_같은_커스텀_구분자() {
        // given
        String input = "//,\\n1,2,3";

        // when & then
        assertThatThrownBy(() -> CustomDelimiterExtractor.extract(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CUSTOM_DUPLICATE_CUSTOM_DELIMITER.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자가 공백일 경우 예외 처리")
    void 공백인_커스텀_구분자() {
        // given
        String input = "//  \\n1,2,3";

        // when & then
        assertThatThrownBy(() -> CustomDelimiterExtractor.extract(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CUSTOM_DELIMITER_IS_SPACE.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자가 비어있을 경우 예외 처리")
    void 비어있는_커스텀_구분자() {
        // given
        String input = "//\\n3,5;3";

        // when & then
        assertThatThrownBy(() -> CustomDelimiterExtractor.extract(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CUSTOM_DELIMITER_IS_EMPTY.getMessage());
    }
}