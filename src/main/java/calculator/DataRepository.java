package calculator;

import java.util.List;

public class DataRepository {

    private String customSplitter;
    private String inputString;

    public String getCustomSplitter() {
        return customSplitter;
    }

    public String getInputString() {
        return inputString;
    }

    public void setCustomSplitter(String customSplitter) {
        this.customSplitter = customSplitter;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
}
