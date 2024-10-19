package calculator.domain.service;

import dto.InputDTO;

public interface SpecialCalculator {

    int calculate(InputDTO inputDTO, String delimiter);

}
