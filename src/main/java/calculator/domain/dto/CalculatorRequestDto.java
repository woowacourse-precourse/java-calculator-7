package calculator.domain.dto;

import calculator.domain.Calculator;

public record CalculatorRequestDto(
        String formula,
        String separator
){
    public Calculator toEntity(){
        return new Calculator(formula,separator);
    }
}
