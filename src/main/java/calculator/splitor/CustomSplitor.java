package calculator.splitor;

import calculator.dto.SplittedResult;
import calculator.validator.Validator;

import java.util.List;

public class CustomSplitor extends Splitor {
    private final Validator validator = new Validator();
    private final String custom_seperator;
    private final String SEPERATOR_REGEX;
    private final String OTHER_SEPERATOR_REGEX;

    public CustomSplitor(String numString, String seperator) {
        super(numString);
        this.custom_seperator = seperator;
        this.SEPERATOR_REGEX = "[" + SEPERATOR_COLON + SEPERATOR_COMMA + custom_seperator + "]";
        this.OTHER_SEPERATOR_REGEX = ".*" + "[^0-9" + SEPERATOR_COLON + SEPERATOR_COMMA + custom_seperator + "]" + ".*";
    }

    @Override
    public SplittedResult split() {
        validator.validateSeperator(OTHER_SEPERATOR_REGEX, numString);

        return new SplittedResult(List.of(numString.split(SEPERATOR_REGEX)));
    }
}
