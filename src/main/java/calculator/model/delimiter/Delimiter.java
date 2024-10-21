package calculator.model.delimiter;

import calculator.validator.DuplicatedCharacterValidator;
import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private final List<String> delimiters;

    private Delimiter(List<String> customDelimiters) {
        this.delimiters = new ArrayList<>(customDelimiters);
        delimiters.addAll(DefaultDelimiter.getDefaultDelimiters());
    }

    private Delimiter() {
        this.delimiters = DefaultDelimiter.getDefaultDelimiters();
    }

    //splitPattern(String)을 생성한다.
    public String generateSplitPattern() {
        return String.join("|", delimiters);
    }

    public static Delimiter createDelimiter(List<String> customDelimiter) {
        DuplicatedCharacterValidator.validate(customDelimiter);
        return new Delimiter(customDelimiter);
    }

    public static Delimiter createDelimiter() {
        return new Delimiter();
    }
}
