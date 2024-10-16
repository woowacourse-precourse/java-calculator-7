package calculator.domain.calculator.service;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest {

    @Test
    void TDD_빈_문자열_일때_0을_반환() {
    	//given
        String input = "";

    	//when
        CalculatorService calculatorService = new CalculatorService();
        BigInteger result = calculatorService.sum(input);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void TDD_기본_구분자_쉼표_문자열_계산() {
        //given
        String input = "1,2,3";

        //when
        CalculatorService calculatorService = new CalculatorService();
        BigInteger sum = calculatorService.sum(input);

        //then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 기본_구분자_혼합_문자열_계산() {
        //given
        String input = "1:2,3";

        //when
        CalculatorService calculatorService = new CalculatorService();
        BigInteger sum = calculatorService.sum(input);

        //then
        assertThat(sum).isEqualTo(6);
    }
}
