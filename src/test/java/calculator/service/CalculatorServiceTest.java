package calculator.service;

import calculator.dto.CalculatorDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    @DisplayName("커스텀 구분자 O")
    void hasCustomDelimiter(){
        //given
        String str = "//;/\\n1;/2;/3";
        CalculatorDTO calculatorDTO = new CalculatorDTO(str);

        //when
        CalculatorService calculatorService = CalculatorConfig.getCalculatorService(calculatorDTO);
        int result = calculatorService.calculate(calculatorDTO);

        //then
        assertThat(calculatorService).isInstanceOf(CalculatorServiceCustomImpl.class);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 X")
    void hasNoCustomDelimiter(){
        //given
        String str = "1,2:3";
        CalculatorDTO calculatorDTO = new CalculatorDTO(str);

        //when
        CalculatorService calculatorService = CalculatorConfig.getCalculatorService(calculatorDTO);
        int result = calculatorService.calculate(calculatorDTO);

        //then
        assertThat(calculatorService).isInstanceOf(CalculatorServiceImpl.class);
        assertThat(result).isEqualTo(6);
    }

}