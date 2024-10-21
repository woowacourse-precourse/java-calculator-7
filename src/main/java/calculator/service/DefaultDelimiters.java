package calculator.service;

import java.util.List;

public enum DefaultDelimiters {
    INSTANCE;

    private final List<String> delimiters;

    DefaultDelimiters() {
        this.delimiters = List.of(",", ":");
    }

    public String getDefaultDelimiters() {
        return String.join("|", delimiters);
    }
}
