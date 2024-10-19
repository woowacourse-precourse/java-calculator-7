package calculator;

import java.util.List;

public interface StringSplitter {

    static final String DEFAULT_DELIMITERS = ",:";
    List<String> splitString(String str);
}
