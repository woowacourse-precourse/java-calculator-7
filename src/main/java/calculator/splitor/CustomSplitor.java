package calculator.splitor;

import calculator.InputString;
import calculator.SplittedResult;

import java.util.List;

public class CustomSplitor extends Splitor {
    private final String custom_seperator;

    public CustomSplitor(String numString, String seperator) {
        super(numString);
        this.custom_seperator = seperator;
    }

    @Override
    public SplittedResult split() {
//        String substring = numString.substring(5);
        String regex = String.format("[%s%s%s]", SEPERATOR_COLON, SEPERATOR_COMMA, custom_seperator);
        return new SplittedResult(List.of(numString.split(regex)));
    }
}
