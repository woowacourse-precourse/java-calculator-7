package calculator.controller.converter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.controller.converter.mock.MockExpression;
import calculator.model.expression.Expression;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionToPositiveIntegerOperandConverterTest {

    private final ExpressionToPositiveIntegerOperandConverter converter = new ExpressionToPositiveIntegerOperandConverter();

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @ParameterizedTest
        @DisplayName("음수, 0, 숫자가 아닌 입력이 포함된 경우 IllegalArgumentException이 발생한다")
        @ValueSource(strings = {"A", " ", "-1", "0"})
        void testInvalidOperands(final String invalidOperand) {
            Expression expression = new MockExpression(null, null, List.of("1", invalidOperand, "3"));

            assertThatThrownBy(() -> converter.convert(expression))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
