package calculator;

public class Separator {
    private final String target;
    private final DelimiterManager delimiterManager;

    Separator(String target, DelimiterManager delimiterManager) {
        this.target = target;
        this.delimiterManager = delimiterManager;
    }
}
