package calculator;

import calculator.io.Input;
import calculator.io.View;
import calculator.operator.Operator;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();

        final View view = new View();
        view.printInstruction();

        String inputString = Input.readLine();
        Operator operator = appConfig.operator(inputString);
        String result = operator.toString();

        view.printResult(result);
    }
}
