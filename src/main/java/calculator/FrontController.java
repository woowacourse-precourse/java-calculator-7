package calculator;

import calculator.IO.InputService;

public class FrontController {
    public void run() {
        AppConfig appConfig = AppConfig.getInstance();

        InputService inputService = appConfig.getInputService();
        inputService.readFormula();
    }
}