package calculator.domain.service;

import dto.InputDTO;
import dto.ResultDTO;

public class CalculateService {
    private final NormalCalculator normalCalculator;
    private final SpecialCalculator specialCalculator;

    //생성자 구현
    public CalculateService(NormalCalculator normalCalculator, SpecialCalculator specialCalculator) {
        this.normalCalculator = normalCalculator;
        this.specialCalculator = specialCalculator;
    }

    public ResultDTO calculate(InputDTO inputDTO) {
        String input = inputDTO.getInput();
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            String delimiter = input.substring(2, delimiterIndex);
            String numbers = input.substring(delimiterIndex + 1);
            int result = specialCalculator.calculate(new InputDTO(numbers), delimiter);
            return new ResultDTO(result);
        } else {
            int result = normalCalculator.calculate(inputDTO);
            return new ResultDTO(result);
        }
    }
}
