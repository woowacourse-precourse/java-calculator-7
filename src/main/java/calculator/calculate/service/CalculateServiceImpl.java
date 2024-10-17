package calculator.calculate.service;

import calculator.calculate.dto.request.CalculateRequestDTO;
import calculator.calculate.dto.response.CalculateResponseDTO;
import calculator.calculate.exception.InvalidFormatException;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {

    @Override
    public CalculateResponseDTO calculate(CalculateRequestDTO calculateRequestDTO) {
        List<Integer> numbers = calculateRequestDTO.numbers();
        if (numbers.stream().anyMatch(number -> number <= 0)) {
            throw new InvalidFormatException("양수만 입력해야 합니다.");
        }

        int sum = numbers.stream().reduce(0, Integer::sum);

        return new CalculateResponseDTO(sum);
    }
}