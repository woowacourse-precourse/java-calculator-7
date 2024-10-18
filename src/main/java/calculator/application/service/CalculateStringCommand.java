package calculator.application.service;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.response.CalculationResponse;
import calculator.domain.service.AdditionService;

import calculator.application.usecase.CalculateStringUseCase;
import calculator.application.validation.InputValidator;

public class CalculateStringCommand implements CalculateStringUseCase {

    private AdditionService additionService;
    private InputValidator inputValidator;

    public CalculateStringCommand(InputValidator inputValidator, AdditionService additionService) {
        this.inputValidator = inputValidator;
        this.additionService = additionService;
    }

    @Override
    public CalculationResponse calculate(CalculationRequest request) {
        inputValidator.validate(request);
        return additionService.compute(request);
    }
}
