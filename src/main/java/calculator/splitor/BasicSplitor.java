package calculator.splitor;

import calculator.InputString;
import calculator.SplittedResult;
import calculator.util.IntegerConverter;

import java.util.List;

public class BasicSplitor extends Splitor {
    public BasicSplitor(String inputString) {
        super(inputString);
    }

    @Override
    public SplittedResult split() {
        String regex = String.format("[%s%s]", SEPERATOR_COLON, SEPERATOR_COMMA);
        return new SplittedResult(List.of(numString.split(regex)));
    }
}
