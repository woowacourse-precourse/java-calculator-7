package calculator.splitor;

import calculator.InputString;
import calculator.SplittedResult;

import java.util.List;

public class CustomSplitor extends Splitor {
    private final String custom_seperator;

    public CustomSplitor(InputString inputString, char seperator) {
        super(inputString);
        this.custom_seperator = String.valueOf(seperator);
    }

    @Override
    public SplittedResult split() {
        InputString substring = inputString.substring(5);

        String regex = String.format("[%s%s%s]", SEPERATOR_COLON, SEPERATOR_COMMA, custom_seperator);
        return new SplittedResult(List.of(substring.split(regex)));
    }
}
