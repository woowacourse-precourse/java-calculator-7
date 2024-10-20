package calculator.splitor;

import calculator.InputString;
import calculator.SplittedResult;
import calculator.util.IntegerConverter;

import java.util.List;

public class BasicSplitor extends Splitor {
    private final String SEPERATOR_REGEX = "[" + SEPERATOR_COLON + SEPERATOR_COMMA + "]";
    private final String OTHER_SEPERATOR_REGEX = ".*" + "[^0-9" + SEPERATOR_COLON + SEPERATOR_COMMA + "]" + ".*";

    public BasicSplitor(String inputString) {
        super(inputString);
    }

    @Override
    public SplittedResult split() {
        StringBuilder sb = new StringBuilder();
        sb.append(SEPERATOR_COLON).append(SEPERATOR_COMMA);

        if (numString.matches(OTHER_SEPERATOR_REGEX)) {
            throw new IllegalArgumentException("쉼표(,) 또는 콜론(:)이 아닌 다른 구분자는 사용할 수 없습니다.");
        }

        if (numString.matches(SEQUENCE_REGEX)) {
            throw new IllegalArgumentException("구분자를 연속으로 작성할 수 없습니다.");
        }

        return new SplittedResult(List.of(numString.split(SEPERATOR_REGEX)));
    }
}
