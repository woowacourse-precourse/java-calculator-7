package calculator.model;

import static calculator.util.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegDelimiter {
    private List<String> delimiters;
    private CustomDelimiter customDeli;

    public RegDelimiter() {
        this.delimiters = new ArrayList<>(Arrays.asList(DEFAULT_DELIMITERS));
        this.customDeli = new CustomDelimiter();
    }

    public void registerCustomDelimiter(String value) {
        customDeli.register(value);
        if (customDeli.exists()) {
            addCustomDeliToDelimiters(customDeli.getValue());
        }
    }

    private void addCustomDeliToDelimiters(String customDeli) {
        this.delimiters.add(customDeli);
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public CustomDelimiter getCustomDeli() {
        return customDeli;
    }

    public int getCustomDeliEndIdx() {
        return customDeli.getValueEndIdx();
    }
}