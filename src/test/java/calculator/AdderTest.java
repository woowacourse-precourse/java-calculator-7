package calculator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AdderTest {

    private Adder adder;

    @ParameterizedTest
    @EnumSource(ExpressionTestCase.class)
    void sum(ExpressionTestCase testCase) {
        //given
        final Adder adder = new Adder(testCase.delimiters, testCase.operands);

        //when
        final int sum = adder.sum();

        //then
        assertThat(sum).isEqualTo(testCase.sum);
    }
}