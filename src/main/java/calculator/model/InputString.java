package calculator.model;

import java.util.List;

public class InputString {
    private String userInput;
    private List<Integer> userOperand;

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserOperand(List<Integer> userOperand) {
        this.userOperand = userOperand;
    }

    public List<Integer> getUserOperand() {
        return userOperand;
    }
}
