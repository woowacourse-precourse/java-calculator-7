package calculator.domain.service;


import calculator.domain.dto.InputDTO;

public interface SpecialCalculator {

    int calculate(InputDTO inputDTO, String delimiter);

}
