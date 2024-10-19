package calculator.back.service.impl;

import calculator.back.dto.RequestDTO;
import calculator.back.service.CalculatorService;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Integer calculate(RequestDTO requestDTO) {
        List<Character> delimiters = requestDTO.delimiters();
        String inputWithDelimiters = requestDTO.inputWithDelimiters();
        if (inputWithDelimiters.isEmpty()) {
            return 0;
        }
        List<Integer> integers = DelimitedNumberParser.parseDelimitedNumber(inputWithDelimiters, delimiters);
        return integers.stream().reduce(0, Integer::sum);
    }
}
