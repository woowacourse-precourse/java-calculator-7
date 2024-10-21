package calculator.business;

import calculator.object.CalculationFormula;
import calculator.view.ConsoleView;

public class StringCalculator {

    public void run() {
        ConsoleView view = new ConsoleView();

        String inputCalculationFormula = view.askAdditionFormulaString();

        CalculationFormula calculationFormula = CalculationFormula.from(inputCalculationFormula);
        String result = calculationFormula.calculate();

        view.tellResult(result);
    }

}
