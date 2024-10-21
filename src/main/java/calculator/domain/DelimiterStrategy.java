package calculator.domain;

import java.util.List;

public interface DelimiterStrategy {
    List<String> split(String input);
}
