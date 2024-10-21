package calculator.global;

import calculator.application.*;
import calculator.domain.service.Calculator;
import calculator.presentation.TextCalculatorController;
import calculator.application.TextCalculatorService;

public final class AppConfig {


    public TextCalculatorController controller() {
        return new TextCalculatorController(service());
    }

    public TextCalculatorService service() {
        return new TextCalculatorServiceImpl(calculator());
    }

    public Calculator calculator() {
        return new Calculator();
    }
}
