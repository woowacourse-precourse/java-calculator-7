package calculator;

import calculator.customSeparatorExtractor.CustomSeparatorExtractorImpl;
import calculator.numberExtractor.NumberExtractorImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void 커스텀구분자가_없는_문자열을_전달하면_덧셈결과가_반환된다() {
        //given
        CustomSeparatorExtractorImpl customSeparatorExtractor = new CustomSeparatorExtractorImpl();
        NumberExtractorImpl numberExtractor = new NumberExtractorImpl();
        Calculator calculator = new Calculator();

        StringCalculator sut = new StringCalculator(customSeparatorExtractor, numberExtractor, calculator);

        //when
        int result = sut.calculate("", "1:2,3");

        //then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀구분자가_존재하는_문자열을_전달하면_덧셈결과가_반환된다() {
        //given
        CustomSeparatorExtractorImpl customSeparatorExtractor = new CustomSeparatorExtractorImpl();
        NumberExtractorImpl numberExtractor = new NumberExtractorImpl();
        Calculator calculator = new Calculator();

        StringCalculator sut = new StringCalculator(customSeparatorExtractor, numberExtractor, calculator);

        //when
        int result = sut.calculate(";", "1:2,3;4");

        //then
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void 커스텀구분자가_여러개_존재하는_문자열을_전달하면_덧셈결과가_반환된다() {
        //given
        CustomSeparatorExtractorImpl customSeparatorExtractor = new CustomSeparatorExtractorImpl();
        NumberExtractorImpl numberExtractor = new NumberExtractorImpl();
        Calculator calculator = new Calculator();

        StringCalculator sut = new StringCalculator(customSeparatorExtractor, numberExtractor, calculator);

        //when
        int result = sut.calculate(";^&", "1;2^3&4");

        //then
        Assertions.assertThat(result).isEqualTo(10);
    }
}