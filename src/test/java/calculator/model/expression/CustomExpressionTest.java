package calculator.model.expression;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CustomExpressionTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("\n이 포함된 커스텀 구분자를 올바르게 파싱한다")
        void testValidCustomDelimiter() {
            // given
            String input = "//;\\n1;2;3";
            CustomExpression expression = new CustomExpression(input);

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(expression.getInput()).isEqualTo("//;\\n1;2;3");
                softly.assertThat(expression.getDelimiter()).isEqualTo(Pattern.quote(";"));
                softly.assertThat(expression.getOperands()).isEqualTo(List.of("1", "2", "3"));
            });
        }

        @Test
        @DisplayName("\n 이후 숫자가 없는 경우 0을 반환한다")
        void testEmptyNumbersPart() {
            // given
            String input = "//;\\n";
            CustomExpression expression = new CustomExpression(input);

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(expression.getInput()).isEqualTo("//;\\n");
                softly.assertThat(expression.getDelimiter()).isEqualTo(Pattern.quote(";"));
                softly.assertThat(expression.getOperands()).isEqualTo(List.of("0"));
            });
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("입력이 null이면 IllegalArgumentException을 발생시킨다")
        void testNullInput() {
            // given & when & then
            assertThatThrownBy(() -> new CustomExpression(null))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("//이 없으면 IllegalArgumentException을 발생시킨다")
        void testInvalidFormatNoSlash() {
            // given
            String input = ";\\n1;2;3";

            // when & then
            assertThatThrownBy(() -> new CustomExpression(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구분자 뒤에 \\n이 없으면 IllegalArgumentException을 발생시킨다")
        void testInvalidFormatNoNewline() {
            // given
            String input = "//;1;2;3";

            // when & then
            assertThatThrownBy(() -> new CustomExpression(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구분자가 없으면 IllegalArgumentException을 발생시킨다")
        void testInvalidFormatNoDelimiter() {
            // given
            String input = "//\\n1;2;3";

            // when & then
            assertThatThrownBy(() -> new CustomExpression(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
