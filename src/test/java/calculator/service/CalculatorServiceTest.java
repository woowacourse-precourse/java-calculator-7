package calculator.service;

import calculator.dto.CalculatorDTO;
import org.junit.jupiter.api.Assertions;
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

    @Test
    @DisplayName("중간에 계산 대상이 정수가 아닌 경우")
    void hasNoCustomDelimiterExceptionCheck(){
        //given
        String str = "1,2: ";
        CalculatorDTO calculatorDTO = new CalculatorDTO(str);

        //when
        CalculatorService calculatorService = CalculatorConfig.getCalculatorService(calculatorDTO);
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->calculatorService.calculate(calculatorDTO));
    }

    @Test
    @DisplayName("중간에 계산 대상이 정수가 아닌 경우")
    void hasCustomDelimiterExceptionCheck(){
        //given
        String str = "//?\\n1?2?*";
        CalculatorDTO calculatorDTO = new CalculatorDTO(str);

        //when
        CalculatorService calculatorService = CalculatorConfig.getCalculatorService(calculatorDTO);
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->calculatorService.calculate(calculatorDTO));
    }
}