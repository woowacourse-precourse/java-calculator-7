package calculator.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.enums.ErrorMessage;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    @Nested
    @DisplayName("parse 메서드는")
    class ParseMethod {

        @Test
        void 커스텀_구분자가_없는_경우_예외를_발생시킨다() {
            // given
            String input = "//\\n1,2,3";

            // when & then
            assertThatThrownBy(() -> CustomDelimiterExtractor.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CUSTOM_DELIMITER_NOT_FOUND.getMessage());
        }

        @Test
        void 커스텀_구분자가_있는_경우_예외를_발생시키지_않는다() {
            // given
            String input = "//;\\n1;2;3";

            // when & then
            assertThatNoException().isThrownBy(() -> CustomDelimiterExtractor.parse(input));
        }

        @Test
        void 커스텀_구분자에_숫자가_포함된_경우_예외를_발생시킨다() {
            // given
            String input = "//1\\n1,2,3";

            // when & then
            assertThatThrownBy(() -> CustomDelimiterExtractor.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CUSTOM_DELIMITER_CANNOT_CONTAIN_NUMERIC.getMessage());
        }

        @Test
        void 커스텀_구분자로_공백을_허용한다() {
            // given
            String input = "// \\n1 2 3";

            // when & then
            assertThatNoException().isThrownBy(() -> CustomDelimiterExtractor.parse(input));
        }

        @Test
        void 여러개의_커스텀_구분자를_처리한다() {
            // given
            String input = "//@\\n//&\\n4&6@7";
            Set<String> expectedDelimiters = Set.of("@", "&");

            // when
            Set<String> result = CustomDelimiterExtractor.parse(input);

            // then
            assertThat(result).isEqualTo(expectedDelimiters);
        }

        @Test
        void 커스텀_구분자는_문자열_앞쪽에_위치해야_한다() {
            // given
            String input = "1,2,3//;\\n1;2;3";

            // when & then
            assertThatThrownBy(() -> CustomDelimiterExtractor.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CUSTOM_DELIMITER_MUST_BE_IN_FRONT.getMessage());
        }

    }
}