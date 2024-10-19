package calculator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


import java.util.List;
import java.util.Set;

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
    class Check_fail_Throws_IllegalArgumentException {

        @Test
        void When_contains_custom_delimiter_prefix() {
            //given
            final Set<String> delimiters = Set.of(",", ":", "//");

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Expression.checkDelimitersConstraints(delimiters));
        }

        @Test
        void When_contains_custom_delimiter_suffix() {
            //given
            final Set<String> delimiters = Set.of(",", ":", "\\n", "");

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Expression.checkDelimitersConstraints(delimiters));
        }

        @Test
        void When_delimiter_is_numeric() {
            //given
            final Set<String> delimiters = Set.of(",", ":", "123");

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Expression.checkDelimitersConstraints(delimiters));
        }

        @Test
        void When_operand_is_not_numeric() {
            //given
            final List<String> operands = List.of("123", "234", "abc");

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Expression.checkOperandsConstraints(operands));
        }
    }
}