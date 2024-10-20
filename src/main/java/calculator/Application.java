package calculator;

import calculator.Domain.Calculator;
import calculator.Domain.Extractor;
import calculator.View.InputView;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String calculationInput = InputView.readCalculationInput();

        ArrayList<Integer> extractedNumbers = Extractor.extractNumbers(calculationInput);
        int result = Calculator.addNumbers(extractedNumbers);
        
    }
}
