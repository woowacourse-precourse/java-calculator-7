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
        StringBuilder sb = new StringBuilder();
        sb.append(SEPERATOR_COLON).append(SEPERATOR_COMMA);

        if (numString.matches(".*" + "[^0-9" + sb +"]" + ".*")) {
            throw new IllegalArgumentException("쉼표(,) 또는 콜론(:)이 아닌 다른 구분자는 사용할 수 없습니다.");
        }

        if (numString.matches(".*\\D{2,}.*")) {
            throw new IllegalArgumentException("구분자를 연속으로 작성할 수 없습니다.");
        }

        String regex = String.format("[%s%s]", SEPERATOR_COLON, SEPERATOR_COMMA);

        return new SplittedResult(List.of(numString.split(regex)));
    }
}
