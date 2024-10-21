package calculator.splitor;

import calculator.dto.SplittedResult;
import calculator.validator.Validator;

import java.util.List;

public class BasicSplitor extends Splitor {
    private final Validator validator = new Validator();
    private final String SEPERATOR_REGEX = "[" + SEPERATOR_COLON + SEPERATOR_COMMA + "]";
    private final String OTHER_SEPERATOR_REGEX = ".*" + "[^0-9" + SEPERATOR_COLON + SEPERATOR_COMMA + "]" + ".*";

    public BasicSplitor(String inputString) {
        super(inputString);
    }

    @Override
    public SplittedResult split() {
        validator.validateSeperator(OTHER_SEPERATOR_REGEX, numString);

        return new SplittedResult(List.of(numString.split(SEPERATOR_REGEX)));
    }
}
