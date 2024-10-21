package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculateC {
    private CalculateM model;
    private CalculateV view;

    public CalculateC(CalculateM model, CalculateV view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.promptInput();
        String input = Console.readLine();
        try {
            int result = model.calculate(input);
            view.printResult(result);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            throw e;
        }
    }
}