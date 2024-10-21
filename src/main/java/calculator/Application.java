package calculator;

import calculator.addCalculator.AddCalculator;
import calculator.model.MainCalculator;
import calculator.stringSplitter.StringController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringController controller = new StringController();
        AddCalculator addCalculator = new AddCalculator();
        MainCalculator mainCalculator = new MainCalculator(addCalculator,controller);
        mainCalculator.run();
    }
}
