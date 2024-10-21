package calculator.Manager;

import calculator.service.CalculatorService;
import calculator.service.PlusCalculator;
import calculator.view.CalculatorView;

import java.util.List;

public class CalculatorManager {

    private static CalculatorManager instance;

    private CalculatorManager() {
    }

    public static CalculatorManager getInstance() {
        if (instance == null) instance = new CalculatorManager();
        return instance;
    }

    static CalculatorView view = CalculatorView.getInstance();
    static CalculatorService service = PlusCalculator.getInstance();


    public void run() {
        String rexNumber = view.printInputString();
        List<String> numList = service.splitDigits(rexNumber);
        view.printResult(service.operation(numList));
    }
}
