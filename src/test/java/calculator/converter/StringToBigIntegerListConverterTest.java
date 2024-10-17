package calculator.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class StringToBigIntegerListConverterTest {

    StringToBigIntegerListConverter converter;

    @BeforeEach
    void before() {
        converter = new StringToBigIntegerListConverter();
    }

    @Test
    void TDD_문자열_숫자_리스트_반환_기본_구분자_쉼표() {
        //given
        String input = "1,2,3";
        List<String> delimiters = List.of(",");

        //when
        List<BigInteger> list = converter.convert(input, delimiters);

        //then
        assertThat(list).containsExactly(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3));
    }

    @Test
    void TDD_문자열_숫자_리스트_반환_기본_구분자_콜론() {
        //given
        String input = "1:2:3";
        List<String> delimiters = List.of(":");

        //when
        List<BigInteger> list = converter.convert(input, delimiters);

        //then
        assertThat(list).containsExactly(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3));
    }

    @Test
    void 문자열_숫자_리스트_반환_기본_구분자_혼합() {
        //given
        String input = "1:2,3";
        List<String> delimiters = List.of(":", ",");

        //when
        List<BigInteger> list = converter.convert(input, delimiters);

        //then
        assertThat(list).containsExactly(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3));
    }

    @Test
    void 문자열_숫자_리스트_반환_커스텀_구분자_파이프() {
        //given
        String input = "4|2|3";
        List<String> delimiters = List.of("|");

        //when
        List<BigInteger> list = converter.convert(input, delimiters);

        //then
        assertThat(list).containsExactly(BigInteger.valueOf(4), BigInteger.valueOf(2), BigInteger.valueOf(3));
    }

    @Test
    void 문자열_숫자_리스트_반환_구분자_혼합() {
        //given
        String input = "5:6|7,8";
        List<String> delimiters = List.of(":", ",", "|");

        //when
        List<BigInteger> list = converter.convert(input, delimiters);

        //then
        assertThat(list).containsExactly(BigInteger.valueOf(5),
                BigInteger.valueOf(6),
                BigInteger.valueOf(7),
                BigInteger.valueOf(8));
    }
}
