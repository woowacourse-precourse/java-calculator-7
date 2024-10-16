package calculator.domain.calculator.utils;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorConverterUtilsTest {

    @Test
    void TDD_문자열_쉼표_구분자_리스트_반환() {
        //given
        String input = "1,2,3";

        //when
        List<BigInteger> list = CalculatorConverterUtils.convert(input);

        //then
        assertThat(list).containsExactly(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3));
    }

    @Test
    void TDD_문자열_콜론_구분자_리스트_반환() {
        //given
        String input = "1:2:3";

        //when
        List<BigInteger> list = CalculatorConverterUtils.convert(input);

        //then
        assertThat(list).containsExactly(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3));
    }

    @Test
    void 문자열_기본_구분자_혼합_리스트_반환() {
        //given
        String input = "1:2,3";

        //when
        List<BigInteger> list = CalculatorConverterUtils.convert(input);

        //then
        assertThat(list).containsExactly(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3));
    }
}
