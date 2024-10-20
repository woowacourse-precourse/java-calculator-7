package calculator.splitor;

import calculator.InputString;
import calculator.SplittedResult;

import java.util.List;

public abstract class Splitor {
    protected final String numString;
    protected final String SEPERATOR_COLON = ":";
    protected final String SEPERATOR_COMMA = ",";
    protected final String SEQUENCE_REGEX = ".*\\D{2,}.*";

    protected Splitor(String numString) {
        this.numString = numString;
    }

    abstract public SplittedResult split();
}
