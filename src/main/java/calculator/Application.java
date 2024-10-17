package calculator;

import calculator.config.ApplicationConfiguration;
import calculator.controller.Controller;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        Controller controller = applicationConfiguration.controller();
        controller.service();
    }
}

