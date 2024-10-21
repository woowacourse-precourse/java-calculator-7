package calculator.calculator;

import calculator.calculator.utils.NumberExtractor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {

    NumberExtractor extractor;

    @BeforeEach
    void setUp() {
        extractor = new NumberExtractor();
    }

    @DisplayName("공백 문자열을 계산하면 0을 반환한다.")
    @Test
    void splitAndSumWithEmpty() {
        //given
        SumCalculator sumCalculator = new SumCalculator(extractor);
        String source = "";

        //when
        int result = sumCalculator.splitAndSumWith(source);

        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("하나의 기본 구분자로 문자열을 구분하여 더한 값을 반환할 수 있다.")
    @Test
    void splitAndSumWithSeparator() {
        //given
        SumCalculator sumCalculator = new SumCalculator(extractor);
        String source = "1,2";

        //when
        int result = sumCalculator.splitAndSumWith(source);

        //then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("기본 구분자들로 문자열을 구분하여 더한 값을 반환할 수 있다.")
    @Test
    void splitAndSumWithSeparators() {
        //given
        SumCalculator sumCalculator = new SumCalculator(extractor);
        String source = "1,2:3";

        //when
        int result = sumCalculator.splitAndSumWith(source);

        //then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자로 문자열을 구분하여 더한 값을 반환할 수 있다.")
    @Test
    void splitAndSumWithCustomSeparator() {
        //given
        SumCalculator sumCalculator = new SumCalculator(extractor);
        String source = "//;\\n5;6;7";

        //when
        int result = sumCalculator.splitAndSumWith(source);

        //then
        assertThat(result).isEqualTo(18);
    }

    @DisplayName("커스텀 구분자들로 문자열을 구분하여 더한 값을 반환할 수 있다.")
    @Test
    void splitAndSumWithCustomSeparators() {
        //given
        SumCalculator sumCalculator = new SumCalculator(extractor);
        String source = "//,;\\n4,5;6";

        //when
        int result = sumCalculator.splitAndSumWith(source);

        //then
        assertThat(result).isEqualTo(15);
    }
}