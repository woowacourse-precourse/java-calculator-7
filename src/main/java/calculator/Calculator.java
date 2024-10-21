package calculator;

import java.util.List;

public class Calculator {

    private final CalculatorView view = new CalculatorView();
    private final StringSplitterManager splitterManager = new StringSplitterManager(
            List.of(
                    new DefaultStringSplitter(),
                    new CustomStringSplitter()
            )
    );

    public void run() {
        String input = view.readInput();

        List<String> splitStrings = splitterManager.getSplitStrings(input);
        SumCalculator sumCalculator = new SumCalculator(splitStrings);
        String result = sumCalculator.calculateSum();

        view.printOutput(result);
    }
}
