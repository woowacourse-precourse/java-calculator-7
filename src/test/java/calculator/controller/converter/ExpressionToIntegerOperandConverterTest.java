package calculator.controller.converter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.controller.converter.mock.MockExpression;
import calculator.model.expression.Expression;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionToIntegerOperandConverterTest {

    private final ExpressionToIntegerOperandConverter converter = new ExpressionToIntegerOperandConverter();

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @ParameterizedTest
        @DisplayName("숫자로 변환할 수 없는 값이 포함된 경우 IllegalArgumentException이 발생한다")
        @ValueSource(strings = {"A", " "})
        void testNonNumericOperands(final String invalidOperand) {
            // given
            Expression expression = new MockExpression(null, null, List.of("1", invalidOperand, "3"));

            // when & then
            assertThatThrownBy(() -> converter.convert(expression))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
