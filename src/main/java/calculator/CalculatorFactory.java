package calculator;

import calculator.addCalculator.AddCalculator;
import calculator.model.MainCalculator;
import calculator.stringSplitter.StringController;

public class CalculatorFactory {
    public static MainCalculator createCalculator(){
        StringController controller = new StringController();
        AddCalculator addCalculator = new AddCalculator();
        return new MainCalculator(addCalculator, controller);
    }
}
