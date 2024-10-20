package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private String userInput;
    private final String startComment = "덧셈할 문자열을 입력해 주세요.";
    private final String customPrefix = "//";
    private Separator separator;
    private CalculatingMachine calculatingMachine;

    public CalculatorController() {
        this.userInput = "";
        this.calculatingMachine = new CalculatingMachine();
    }

    public Long startCalculate() {
        System.out.println(startComment);
        this.userInput = Console.readLine();
        if (userInput.startsWith(customPrefix)) {
            this.separator = new CustomSeparator();
            return calculatingMachine.calculate(separator.separate(userInput));
        }
        this.separator = new DefaultSeparator();
        return calculatingMachine.calculate(separator.separate(userInput));
    }
}
