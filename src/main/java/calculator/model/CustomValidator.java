package calculator.model;

import java.util.regex.Matcher;

public class CustomValidator implements Validator{

    private final Matcher matcher;

    public CustomValidator(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public ParsedInput validate(String input) {

        return null;
    }
}
