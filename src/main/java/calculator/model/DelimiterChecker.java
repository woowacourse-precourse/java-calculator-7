package calculator.model;

import static calculator.common.DelimiterConstant.CUSTOM_DELIMITER_NOT_FOUND;
import static calculator.common.DelimiterConstant.DELIMITER_CREATOR_BACK;
import static calculator.common.DelimiterConstant.DELIMITER_CREATOR_FRONT;

public class DelimiterChecker {

    public boolean existCustomDelimiter(String value) {
        int frontIndex = value.indexOf(DELIMITER_CREATOR_FRONT);
        int backIndex = value.indexOf(DELIMITER_CREATOR_BACK);

        return frontIndex != CUSTOM_DELIMITER_NOT_FOUND && backIndex != CUSTOM_DELIMITER_NOT_FOUND && frontIndex < backIndex;
    }
}
