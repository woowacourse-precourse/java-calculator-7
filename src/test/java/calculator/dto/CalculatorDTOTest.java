package calculator.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorDTOTest {

    @Test
    @DisplayName("커스텀 구분자 X")
    void constructorTest1(){
        String str = "1,2:3";
        CalculatorDTO calculatorDTO = new CalculatorDTO(str);

        assertThat(calculatorDTO.getStr()).isEqualTo("1,2:3");
        assertThat(calculatorDTO.getDelim()).isEqualTo(",:");
        assertThat(calculatorDTO.hasCustomDelim()).isEqualTo(false);
    }

    @Test
    @DisplayName("커스텀 구분자 O")
    void constructorTest2(){
        String str = "//;\\n1;2;3";
        CalculatorDTO calculatorDTO = new CalculatorDTO(str);

        assertThat(calculatorDTO.getStr()).isEqualTo("1;2;3");
        assertThat(calculatorDTO.getDelim()).isEqualTo(";");
        assertThat(calculatorDTO.hasCustomDelim()).isEqualTo(true);
    }

}