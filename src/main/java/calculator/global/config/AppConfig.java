package calculator.global.config;

import calculator.application.CalculatorService;
import calculator.ui.CalculatorController;
import calculator.ui.CalculatorPresenter;
import java.util.Objects;

public class AppConfig {

    private final CalculatorPresenter calculatorPresenter;
    private final CalculatorService calculatorService;
    private final CalculatorController calculatorController;

    public AppConfig() {
        this.calculatorPresenter = calculatorPresenter();
        this.calculatorService = calculatorService();
        this.calculatorController = calculatorController();
    }

    private CalculatorPresenter calculatorPresenter() {
        return Objects.requireNonNullElseGet(this.calculatorPresenter,
                () -> new CalculatorPresenter(new StringBuilder()));
    }

    private CalculatorService calculatorService() {
        return Objects.requireNonNullElseGet(this.calculatorService, CalculatorService::new);
    }

    private CalculatorController calculatorController() {
        return Objects.requireNonNullElseGet(this.calculatorController,
                () -> new CalculatorController(calculatorPresenter(), calculatorService()));
    }

    public CalculatorController getCalculatorController() {
        return this.calculatorController;
    }

}
