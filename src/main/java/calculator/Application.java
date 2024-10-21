package calculator;

import calculator.addCalculator.AddCalculator;
import calculator.model.MainCalculator;
import calculator.stringSplitter.StringContoller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringContoller contoller = new StringContoller();
        AddCalculator addCalculator = new AddCalculator();
        MainCalculator mainCalculator = new MainCalculator(addCalculator,contoller);
        mainCalculator.run();
    }
}
