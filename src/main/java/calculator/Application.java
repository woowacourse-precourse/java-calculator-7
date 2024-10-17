package calculator;

import calculator.object.CalculateFormula;
import calculator.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();

        String inputCalculationFormula = view.askCalculationFormula();

        String result = CalculateFormula
                .from(inputCalculationFormula)
                .addAll();

        view.showResult(result);
    }

}