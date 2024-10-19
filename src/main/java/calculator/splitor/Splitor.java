package calculator.splitor;

import calculator.InputString;
import calculator.SplittedResult;

import java.util.List;

public abstract class Splitor {
    protected final InputString inputString;
    protected final String SEPERATOR_COLON = ":";
    protected final String SEPERATOR_COMMA = ",";

    protected Splitor(InputString inputString) {
        this.inputString = inputString;
    }

    abstract public SplittedResult split();
}
