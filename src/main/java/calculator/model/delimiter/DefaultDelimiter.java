package calculator.model.delimiter;

import static calculator.enumStatus.DefaultDelimiterType.COLON_DELIMITER;
import static calculator.enumStatus.DefaultDelimiterType.COMMA_DELIMITER;

public class DefaultDelimiter implements Delimiter {
    @Override
    public String getDelimiter(String input) {
        return COMMA_DELIMITER.toString() + COLON_DELIMITER;
    }
}
