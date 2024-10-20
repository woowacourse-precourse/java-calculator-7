package calculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    void 커스텀된_구별자가_포함된_문자열_테스트() {
        // given
        Calculator calculator = new Calculator(new Mathematician(), new NumberFinder(new DelimiterManager()));
        String input = "//;\\n1";
        // when
        System.out.println("=====Logic Start=====");

        int result = calculator.sumOfNumInAlphaNum(input);

        System.out.println("=====Logic End=====");
        // then
        assertThat(result).isEqualTo(1);
    }
    @Test
    void 주어진_구분자가_포함된_문자열_테스트() {
        // given
        Calculator calculator = new Calculator(new Mathematician(), new NumberFinder(new DelimiterManager()));
        String input = "1,2,3:4";
        // when
        System.out.println("=====Logic Start=====");

        int result = calculator.sumOfNumInAlphaNum(input);

        System.out.println("=====Logic End=====");
        // then
        assertThat(result).isEqualTo(10);
    }
    @Test
    void 주어진_구별자와_커스텀된_구별자가_함께_포함된_문자열_테스트() {
        // given
        Calculator calculator = new Calculator(new Mathematician(), new NumberFinder(new DelimiterManager()));
        String input = "//;\\n1,1,2,3:4//[\\n[9[2,1";
        // when
        System.out.println("=====Logic Start=====");

        int result = calculator.sumOfNumInAlphaNum(input);

        System.out.println("=====Logic End=====");
        // then
        assertThat(result).isEqualTo(23);
    }
}