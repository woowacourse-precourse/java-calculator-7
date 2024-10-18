package calculator.service;

import calculator.dto.CalculatorDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceCustomImplTest {

    @Test
    @DisplayName("커스텀 구분자를 지닌 경우")
    void calculateWithoutCustomDelimiter(){
        String str = "//;/\\n1;/2;/3";
        CalculatorDTO calculatorDTO = new CalculatorDTO(str);
        CalculatorService calculatorService = new CalculatorServiceImpl();

        int result = calculatorService.calculate(calculatorDTO);

        assertThat(result).isEqualTo(6);
    }

}