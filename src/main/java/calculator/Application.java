package calculator;

import calculator.global.config.BeanConfig;
import calculator.global.frontController.FrontController;

public class Application {
    public static void main(String[] args) {
        FrontController frontController = BeanConfig.getBean(FrontController.class);
        frontController.run();
    }
}
