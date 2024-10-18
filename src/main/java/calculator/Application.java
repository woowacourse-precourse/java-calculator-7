package calculator;

import calculator.config.BeanConfig;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        FrontController frontController = BeanConfig.getBean(FrontController.class);
        frontController.run();
        Console.close();
    }
}
