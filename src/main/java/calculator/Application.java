package calculator;

import calculator.addCalculator.AddCalculator;
import calculator.model.MainCalculator;
import calculator.stringSplitter.StringSplitter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringSplitter splitter = new StringSplitter();
        AddCalculator addCalculator = new AddCalculator();
        MainCalculator mainCalculator = new MainCalculator(addCalculator,splitter);
        mainCalculator.run();
    }
}
