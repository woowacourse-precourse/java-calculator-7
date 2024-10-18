package calculator.service;

import calculator.dto.CalculatorDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    @Test
    @DisplayName("일반 구분자를 지닌 경우")
    void calculateWithoutCustomDelimiter(){
        String str = "1,2:3";
        CalculatorDTO calculatorDTO = new CalculatorDTO(str);
        CalculatorService calculatorService = new CalculatorServiceImpl();

        int result = calculatorService.calculate(calculatorDTO);
        System.out.println("result = " + result);
    }
}