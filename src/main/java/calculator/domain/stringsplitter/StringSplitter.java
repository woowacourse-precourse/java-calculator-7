package calculator.domain.stringsplitter;

import java.util.List;

public interface StringSplitter {

    static final String DEFAULT_DELIMITER = ":,";
    static final String INVALID_DELIMITER = "+-.";

    boolean canSupport(String str);

    List<String> splitString(String str);

}
