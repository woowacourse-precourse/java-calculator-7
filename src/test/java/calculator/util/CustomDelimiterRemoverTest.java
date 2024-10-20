package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CustomDelimiterRemoverTest {

    @Nested
    @DisplayName("removeCustomDelimiters 메서드는")
    class RemoveCustomDelimitersMethod {

        @Test
        void 커스텀_구분자를_제거할_수_있다() {
            // given
            String input = "//&\\n4&6;7";
            String expected = "4&6;7";

            // when
            String result = CustomDelimiterRemover.removeCustomDelimiters(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        void 여러개의_커스텀_구분자를_제거할_수_있다() {
            // given
            String input = "//@\\n//&\\n4&6@7";
            String expected = "4&6@7";

            // when
            String result = CustomDelimiterRemover.removeCustomDelimiters(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("커스텀 구분자 선언이 없는 경우 그대로 반환한다")
        void 커스텀_구분자가_없는_경우() {
            // given
            String input = "1,2:3";
            String expected = "1,2:3";

            // when
            String result = CustomDelimiterRemover.removeCustomDelimiters(input);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }
}