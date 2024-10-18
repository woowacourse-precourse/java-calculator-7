package calculator;

import calculator.io.Input;
import calculator.io.View;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();

        final View view = new View();
        view.printInstruction();

        String inputString = Input.readLine();
        String result = appConfig.operator(inputString).toString();

        view.printResult(result);
    }
}
