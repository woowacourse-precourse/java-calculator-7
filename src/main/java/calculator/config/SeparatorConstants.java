package calculator.config;

import calculator.model.Separator;
import java.util.List;

public class SeparatorConstants {
    public static final Separator DEFAULT_SEPARATOR_1 = new Separator(',');
    public static final Separator DEFAULT_SEPARATOR_2 = new Separator(':');

    public static final String CUSTOM_SEPARATOR_PREFIX = "//";
    public static final String CUSTOM_SEPARATOR_NEWLINE = "\\\\n";

    public static List<Separator> getDefaultSeparator() {
        return List.of(DEFAULT_SEPARATOR_1, DEFAULT_SEPARATOR_2);
    }
}
