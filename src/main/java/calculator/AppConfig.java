package calculator;

import calculator.domain.machine.Engine;
import calculator.domain.machine.DelimiterExtractor;
import calculator.domain.machine.LineSplitter;
import calculator.domain.machine.View;

public class AppConfig {

    public DelimiterExtractor delimiterExtractor() {
        return new DelimiterExtractor();
    }

    public LineSplitter lineSplitter() {
        return new LineSplitter(delimiterExtractor());
    }

    public Engine calculatorMachine() {
        return new Engine(lineSplitter());
    }

    public View view() {
        return new View();
    }
}
