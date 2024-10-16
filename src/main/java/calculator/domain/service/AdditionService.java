package calculator.domain.service;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.response.CalculationResponse;
import calculator.domain.vo.delimiter.Delimiters;

import calculator.domain.vo.number.Numbers;

public class AdditionService {

    public CalculationResponse compute(final CalculationRequest calculationRequest) {
        String input = calculationRequest.input();

        Delimiters delimiters = Delimiters.from(input);
        Numbers numbers = delimiters.extractNumbers(input);

        return new CalculationResponse(numbers.reduce());
    }
}