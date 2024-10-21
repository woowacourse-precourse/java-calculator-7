package calculator.model;

import java.util.List;

public interface DelimiterManager {

    void init();

    void addDelimiter(String delimiter);

    List<String> getDelimiters();
}
