package calculator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExpressionTest {

    @ParameterizedTest
    @EnumSource(ExpressionTestCase.class)
    void Parse_success(ExpressionTestCase testCase) throws Exception {
        //given
        final String input = testCase.str;

        //when
        final Expression expression = Expression.parse(input);

        //then
        assertThat(expression.getDelimiters()).isEqualTo(testCase.delimiters);
        assertThat(expression.getOperands()).isEqualTo(testCase.operands);
    }

    @Nested
    class Parse_fail_Throws_IllegalArgumentException {

        @Test
        void When_contains_custom_delimiter_prefix() {
            //given
            final String expr = "////\\n123:234//345:456";

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Expression.parse(expr));
        }

        @Test
        void When_contains_custom_delimiter_suffix() {
            //given
            final String expr = "//\\n\\n123:234//345:456";

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Expression.parse(expr));
        }
    }

    @Nested
    class Validate_fail_Throws_IllegalArgumentException {

        @Test
        void When_delimiter_is_numeric() {
            //given
            final String expr = "//1\\n123:234";

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Expression.parse(expr));
        }

        @Test
        void When_operand_is_not_numeric() {
            //given
            final String expr = "123:abc";

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Expression.parse(expr));
        }
    }
}