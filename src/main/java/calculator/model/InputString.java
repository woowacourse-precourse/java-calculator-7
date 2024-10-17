package calculator.model;


import java.util.ArrayList;
import java.util.List;

public class InputString {

    private String inputString;
    private String refinedString;
    private List<String> customDelimiter = new ArrayList(); // List vs ArrayList ?

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public void setRefinedString(String refinedString) {
        this.refinedString = refinedString;
    }

    public List<String> getCustomDelimiter() {
        return customDelimiter;
    }

    public void addCustomDelimiter(String input) {
        if (customDelimiter.size() < 3) {
            this.customDelimiter.add(input);
        }
    }


}
