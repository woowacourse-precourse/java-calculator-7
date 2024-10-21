package calculator.model;

import static calculator.model.DelimiterMode.*;

import calculator.util.Validations;
import java.util.List;

public class Delimiter {
    private String delimiter;
    private DelimiterMode mode;
    private List<String> regDelimiters;

    public Delimiter(RegDelimiter regDelimiter) {
        this.delimiter = "";
        this.mode = NONE;
        this.regDelimiters = regDelimiter.getDelimiters();
    }

    public void updateDelimiterAndMode(String value) {
        this.delimiter += value;
        if (isRegisteredDelimiter()) {
            updateMode(CORRECT);
            initDelimiter();
        } else {
            updateMode(WRONG);
        }
    }

    private boolean isRegisteredDelimiter() {
        for (String regDeli : regDelimiters) {
            if (delimiter.equals(regDeli)) {
                return true;
            }
        }
        return false;
    }

    private void updateMode(DelimiterMode mode) {
        this.mode = mode;
    }

    public void initDelimiter() {
        this.delimiter = "";
    }

    public boolean isNotStarted() {
        return delimiter.isEmpty();
    }

    public void validateDelimiter() {
        Validations.validateCorrectDelimiter(mode);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public DelimiterMode getMode() {
        return mode;
    }
}
