package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private String userInput;

    public Calculator() {

    }

    public Boolean checkInputByRule() {
        return checkInputByRule(this.userInput);
    }
    public Boolean checkInputByRule(String userInput) {
        return false;
    }

    public Integer getSumByCalculate() {
        return this.getSumByCalculate(this.userInput);
    }
    public Integer getSumByCalculate(String userInput) {
        return 0;
    }

    public String setUserInputByCustomConsole() {
        try{
            this.userInput = Console.readLine();
            return this.userInput;
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException(e);
        }

    }

}
