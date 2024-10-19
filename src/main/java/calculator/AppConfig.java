package calculator;

import calculator.IO.InputOutput;
import calculator.controller.Controller;
import calculator.parser.StringParser;

public class AppConfig {
    public InputOutput inputOutput() {
        return new InputOutput();
    }

    public StringParser stringParser() {
        return new StringParser();
    }

    public Controller controller() {
        return new Controller(inputOutput(), stringParser());
    }
}
