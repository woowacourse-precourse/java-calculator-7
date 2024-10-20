package calculator.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    @Nested
    @DisplayName("parse 메서드는")
    class ParseMethod {

        @Test
        void 대응하는_구분자_접미사를_찾을_수_없는_경우_예외를_발생시킨다() {
            // given
            String input = "//;1,2,3";

            // when & then
            assertThatThrownBy(() -> DelimiterExtractor.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DELIMITER_SUFFIX_NOT_FOUND.getMessage());
        }

        @Test
        void 대응하는_구분자_접미사가_있는_경우_예외를_발생시키지_않는다() {
            // given
            String input = "//;\\n1;2;3";

            // when & then
            assertThatNoException().isThrownBy(() -> DelimiterExtractor.parse(input));
        }

        @Test
        void 커스텀_구분자가_없는_경우_예외를_발생시킨다() {
            // given
            String input = "//\\n1,2,3";

            // when & then
            assertThatThrownBy(() -> DelimiterExtractor.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CUSTOM_DELIMITER_NOT_FOUND.getMessage());
        }

        @Test
        void 커스텀_구분자가_있는_경우_예외를_발생시키지_않는다() {
            // given
            String input = "//;\\n1;2;3";

            // when & then
            assertThatNoException().isThrownBy(() -> DelimiterExtractor.parse(input));
        }

        @Test
        void 커스텀_구분자에_숫자가_포함된_경우_예외를_발생시킨다() {
            // given
            String input = "//1\\n1,2,3";

            // when & then
            assertThatThrownBy(() -> DelimiterExtractor.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CUSTOM_DELIMITER_CANNOT_CONTAIN_NUMERIC.getMessage());
        }
    }
}