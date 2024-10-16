package calculator.delimiter.handler;

import java.util.List;

public interface DelimiterHandler {
    List<String> split(String str);

    boolean isSupport(String string);
}
