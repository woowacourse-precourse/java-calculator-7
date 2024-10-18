package calculator.core.controller;

import calculator.core.service.CalculatorCoreService;
import calculator.core.view.CalculatorCoreView;

public class CalculatorCoreController {

    private final CalculatorCoreView view;
    private final CalculatorCoreService service;

    public CalculatorCoreController() {
        this.view = new CalculatorCoreView();
        this.service = new CalculatorCoreService();
    }

    public static CalculatorCoreController getInstance() {
        return new CalculatorCoreController();
    }

    public void run() {
        view.print(service::sum);
    }
}
