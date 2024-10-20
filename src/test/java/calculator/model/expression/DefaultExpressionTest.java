package calculator.model.expression;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DefaultExpressionTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("기본 구분자로 입력값을 올바르게 파싱한다")
        void testValidDefaultDelimiter() {
            // given
            String input = "1,2:3";
            DefaultExpression expression = new DefaultExpression(input);

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(expression.getInput()).isEqualTo("1,2:3");
                softly.assertThat(expression.getOperands()).isEqualTo(List.of("1", "2", "3"));
            });
        }

        @Test
        @DisplayName("입력이 빈 문자열인 경우 0을 반환한다")
        void testEmptyInput() {
            // given
            String input = "";
            DefaultExpression expression = new DefaultExpression(input);

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(expression.getInput()).isEqualTo("");
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
            assertThatThrownBy(() -> new DefaultExpression(null))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
