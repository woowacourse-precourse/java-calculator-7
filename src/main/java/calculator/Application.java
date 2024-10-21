package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.CalculatorUseCase;
import calculator.domain.SumCalculator;
import calculator.domain.repository.InputRepository;
import calculator.domain.view.View;
import calculator.service.MultipleService;
import calculator.view.ConsoleInput;
import calculator.view.ConsoleOutPut;

public class Application {
    public static void main(String[] args) {
        // Dependency
        InputRepository<String> consoleInput = new ConsoleInput();
        View<Integer> consoleOutPut = new ConsoleOutPut();
        SumCalculator sumCalculator = new SumCalculator();
        CalculatorUseCase calculatorUseCase = new MultipleService(sumCalculator);

        // Injection
        CalculatorController controller = new CalculatorController(consoleInput, consoleOutPut, calculatorUseCase);

        controller.run();
    }
}
