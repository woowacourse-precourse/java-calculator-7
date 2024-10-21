package calculator.model;

import calculator.util.Regex;

public class DefaultDelimiter extends Delimiter {
    public DefaultDelimiter() {
        super(Regex.DEFAULT_DELIMITER_FORMAT.getRegex());
    }

    @Override
    public void validate() {

    }
}
