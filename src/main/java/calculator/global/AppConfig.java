package calculator.global;

import calculator.business.*;
import calculator.domain.service.Calculator;
import calculator.presentation.TextCalculatorController;
import calculator.business.TextCalculatorService;

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
