package calculator.model.implement;

import static calculator.common.DelimiterConstant.DELIMITER_CREATOR_BACK;
import static calculator.common.DelimiterConstant.DELIMITER_CREATOR_FRONT;

public class DelimiterExtractor {

    public String extractCustom(String value) {
        int frontStartIndex = value.indexOf(DELIMITER_CREATOR_FRONT);
        int backStartIndex = value.indexOf(DELIMITER_CREATOR_BACK);
        int frontLength = DELIMITER_CREATOR_FRONT.length();
        return value.substring(frontStartIndex + frontLength, backStartIndex);
    }
}
