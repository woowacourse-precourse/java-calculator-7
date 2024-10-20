package calculator.global.frontController;

import calculator.calculate.controller.CalculateController;
import calculator.calculate.dto.request.CalculateRequestDTO;
import calculator.calculate.dto.response.CalculateResponseDTO;
import calculator.calculate.view.CalculateRequestView;
import calculator.calculate.view.CalculateResponseView;

public final class FrontController {

    private final CalculateController calculateController;

    public FrontController(CalculateController calculateController) {
        this.calculateController = calculateController;
    }

    private void calculateRequestHandling() {
        CalculateRequestDTO requestDTO = CalculateRequestView.request();

        CalculateResponseDTO calculate = calculateController.calculate(requestDTO);

        CalculateResponseView.response(calculate);
    }

    public void run() {
        calculateRequestHandling();
    }
}
