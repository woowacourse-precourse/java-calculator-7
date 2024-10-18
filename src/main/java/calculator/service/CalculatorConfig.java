package calculator.service;

import calculator.dto.CalculatorDTO;

public class CalculatorConfig {

    public static CalculatorService getCalculatorService(CalculatorDTO calculatorDTO){
        if(calculatorDTO.hasCustomDelim()){
            return new CalculatorServiceCustomImpl();
        }else{
            return new CalculatorServiceImpl();
        }
    }
}
