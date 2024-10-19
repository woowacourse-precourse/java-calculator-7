package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private String userInput;
    private final String startComment = "덧셈할 문자열을 입력해 주세요.";
    private final String customPrefix = "//";
    private AbstractSeparator abstractSeparator;
    private CalculatingMachine calculatingMachine;

    public CalculatorController() {
        this.userInput = "";
        this.calculatingMachine = new CalculatingMachine();
    }

    public Long startCalculate() {
        System.out.println(startComment);
        this.userInput = Console.readLine();
        if (userInput.startsWith(customPrefix)) {
            this.abstractSeparator = new CustomSeparator();
            return calculatingMachine.calculate(abstractSeparator.separate(userInput));
        }
        this.abstractSeparator = new DefaultSeparator();
        return calculatingMachine.calculate(abstractSeparator.separate(userInput));
    }
}
