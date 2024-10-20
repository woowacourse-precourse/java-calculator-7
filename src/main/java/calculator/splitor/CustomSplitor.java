package calculator.splitor;

import calculator.SplittedResult;

import java.util.List;

public class CustomSplitor extends Splitor {
    private final String custom_seperator;
    private final String OTHER_SEPERATOR_REGEX;

    public CustomSplitor(String numString, String seperator) {
        super(numString);
        this.custom_seperator = seperator;
        this.OTHER_SEPERATOR_REGEX = ".*" + "[^0-9" + SEPERATOR_COLON + SEPERATOR_COMMA + custom_seperator + "]" + ".*";
    }

    @Override
    public SplittedResult split() {
        if (numString.matches(OTHER_SEPERATOR_REGEX)) {
            throw new IllegalArgumentException("쉼표(,) 또는 콜론(:) 또는 커스텀 구분자가 아닌 다른 구분자는 사용할 수 없습니다.");
        }

        if (numString.matches(SEQUENCE_REGEX)) {
            throw new IllegalArgumentException("구분자를 연속으로 작성할 수 없습니다.");
        }

        String regex = String.format("[%s%s%s]", SEPERATOR_COLON, SEPERATOR_COMMA, custom_seperator);
        return new SplittedResult(List.of(numString.split(regex)));
    }
}
