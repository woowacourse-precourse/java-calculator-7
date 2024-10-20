package calculator;

import calculator.config.ApplicationContext;
import calculator.presentation.StringAdditionController;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        StringAdditionController stringAdditionController = context.getStringAdditionController();
        stringAdditionController.run();
    }
}
