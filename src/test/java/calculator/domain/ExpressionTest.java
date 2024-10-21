package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.ExpressionTestCase;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExpressionTest {

    @ParameterizedTest
    @EnumSource(ExpressionTestCase.class)
    void Parse_success(ExpressionTestCase testCase) {
        //given
        final String input = testCase.str;

        //when
        final Expression expression = Expression.parse(input);

        //then
        assertThat(expression.getDelimiters().toSet()).containsAll(testCase.delimiters.toSet());
        assertThat(expression.getOperands().toList()).containsAll(testCase.operands.toList());
    }
}