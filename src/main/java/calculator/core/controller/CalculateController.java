package calculator.core.controller;

import calculator.core.service.CalculateService;
import calculator.core.view.CalculateView;

public class CalculateController {

    private final CalculateView view;
    private final CalculateService service;

    public CalculateController() {
        this.view = new CalculateView();
        this.service = new CalculateService();
    }

    public static CalculateController getInstance() {
        return new CalculateController();
    }

    public void run() {
        view.print(service::calculate);
    }
}
