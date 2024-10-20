package calculator;

import java.util.List;

public interface Delimiter {
    List<String> delimiters = DefaultDelimiter.get();

    public String getDelimiterRegex();

    public String getContentWithoutDelimiter();
}
