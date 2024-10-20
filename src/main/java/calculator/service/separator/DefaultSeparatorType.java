package calculator.service.separator;

import java.util.Arrays;
import java.util.List;

public enum DefaultSeparatorType {

    COMMA(","),
    COLON(":");

    private final String value;

    DefaultSeparatorType(String value) {
        this.value = value;
    }

    public static List<String> getDefaults() {
        return Arrays.stream(values())
                .map(DefaultSeparatorType::getValue)
                .toList();
    }

    public String getValue() {
        return value;
    }
}
