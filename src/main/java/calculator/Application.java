package calculator;

import calculator.config.BeanConfig;

public class Application {
    public static void main(String[] args) {
        FrontController frontController = BeanConfig.getBean(FrontController.class);
        frontController.run();
    }
}
