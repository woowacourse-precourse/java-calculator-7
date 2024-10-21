package calculator.splitor;

import calculator.dto.SplittedResult;

public abstract class Splitor {
    protected final String numString;
    protected final String SEPERATOR_COLON = ":";
    protected final String SEPERATOR_COMMA = ",";

    protected Splitor(String numString) {
        this.numString = numString;
    }

    abstract public SplittedResult split();
}
