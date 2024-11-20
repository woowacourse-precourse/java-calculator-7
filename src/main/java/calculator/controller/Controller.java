package calculator.controller;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.service.domain.ServiceHandler;

public class Controller {
    private final ServiceHandler serviceHandler = new ServiceHandler();

    public void run() {
        String userInupt = InputHandler.makeDelimiterNumberString();
        String answer = serviceHandler.calculate(userInupt);
        OutputHandler.printResult(answer);
    }
}
