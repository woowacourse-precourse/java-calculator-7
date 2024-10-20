package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class DelimiterManagerImpl implements DelimiterManager {

    private final List<String> delimiters = new ArrayList<>();

    @Override
    public void init() {
        if (delimiters.isEmpty()) {
            delimiters.add(",");
            delimiters.add(":");
        }
    }
}
