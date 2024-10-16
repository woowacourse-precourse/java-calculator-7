package calculator.domain.calculator.service;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    //TODO : 구현 필요
    @Test
    void TDD_빈_문자열이_아닐때_예외() {
        //given
        String input = "1,2,3";

        //when
        CalculatorService calculatorService = new CalculatorService();

        //then
        assertThatThrownBy(() -> calculatorService.sum(input)).isInstanceOf(UnsupportedOperationException.class);
    }
}
