package calculator.controller;

import calculator.domain.CalculatorUseCase;
import calculator.domain.repository.InputRepository;
import calculator.domain.view.View;

public class CalculatorController {
    private final InputRepository<String> inputRepository;
    private final View<Integer> view;
    private final CalculatorUseCase calculatorUseCase;

    public CalculatorController(
        InputRepository<String> inputRepository,
        View<Integer> view,
        CalculatorUseCase calculatorUseCase
    ) {
        this.inputRepository = inputRepository;
        this.view = view;
        this.calculatorUseCase = calculatorUseCase;
    }

    public void run() {
        String input = inputRepository.input();
        int result = calculatorUseCase.calculate(input);
        view.render(result);
    }
}
