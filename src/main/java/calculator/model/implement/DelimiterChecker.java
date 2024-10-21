package calculator.model.implement;

import static calculator.common.DelimiterConstant.DELIMITER_CREATOR_BACK;
import static calculator.common.DelimiterConstant.DELIMITER_CREATOR_FRONT;

public class DelimiterChecker {

    private static final int CUSTOM_DELIMITER_NOT_FOUND = -1;

    public boolean existCustomDelimiter(String value) {
        int frontIndex = value.indexOf(DELIMITER_CREATOR_FRONT);
        int backIndex = value.indexOf(DELIMITER_CREATOR_BACK);

        return frontIndex != CUSTOM_DELIMITER_NOT_FOUND && backIndex != CUSTOM_DELIMITER_NOT_FOUND && frontIndex < backIndex;
    }
}
