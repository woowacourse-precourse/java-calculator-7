package calculator;

import java.util.List;

public interface StringSplitter {

    static final String DEFAULT_DELIMITER = ",:";
    static final String INVALID_DELIMITER = "-+.";
    List<String> splitString(String str);
}
