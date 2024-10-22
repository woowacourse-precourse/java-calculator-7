package calculator;

import calculator.global.AppConfig;
import calculator.presentation.io.InputReader;
import calculator.presentation.io.Viewer;
import calculator.presentation.TextCalculatorController;

public class Application {

    public static void main(String[] args) {

        AppConfig config = new AppConfig();
        TextCalculatorController controller = config.controller();

        Viewer.inputMessage();
        Long result = controller.getSumTotal(InputReader.read());
        Viewer.resultMessage(result);
    }
}
