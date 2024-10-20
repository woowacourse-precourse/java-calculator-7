package calculator.application;

import java.util.HashSet;
import java.util.Set;

public class DelimiterSpecification {
    public static final DelimiterList INVALID_CUSTOM_DELIMITER_LIST = DelimiterList.from(new HashSet<>(Set.of(
        Delimiter.from("-")
    )));

    public static DelimiterList createDefaultdelimiterList() {
        return DelimiterList.from(new HashSet<>(Set.of(
            Delimiter.from(","),
            Delimiter.from(":")
        )));
    }
}