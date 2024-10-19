package calculator.delimiter.handler;

import java.util.List;

public interface DelimiterHandler {
    List<String> split(String str) throws IllegalArgumentException;

    boolean isSupport(String string);
}
