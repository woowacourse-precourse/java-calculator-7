package calculator.service;

import calculator.common.InputSplitter;
import calculator.domain.Calculator;
import calculator.dto.CalculatorRequestDto;
import calculator.dto.CalculatorResponseDto;

public class CalculatorService {

    public CalculatorResponseDto sum(CalculatorRequestDto requestDto) {
        String input = requestDto.input();

        InputSplitter inputSplitter = new InputSplitter();
        String[] splitInputs = inputSplitter.split(input);

        Calculator calculator = new Calculator(splitInputs);
        long sumResult = calculator.sum();

        return new CalculatorResponseDto(sumResult);
    }
}
