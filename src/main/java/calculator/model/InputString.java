package calculator.model;

import java.util.Arrays;
import java.util.List;

public class InputString {
    private String userInput;
    private char customSeparator;
    private List<Integer> userOperand;

    public void setUserInput(String userInput) {
        if(userInput.contains("//") && userInput.contains("\\n")) {
            customSeparator = userInput.replaceAll("[//\n]", "").charAt(0);
            String regex = String.format("[,:%s]", customSeparator);
            this.userInput = userInput.substring(userInput.indexOf("n")+1).replaceAll(regex, " ");
        } else {
            this.userInput = userInput.replaceAll("[,:]", " ");
        }
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
