package calculator;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractDelimiterSplitter {

    public SplitResult split(String value) {
        Container container = new Container();
        boolean success = splitValue(container, value);
        if (!success) {
            return SplitResult.fail();
        }
        return SplitResult.success(toList(container.result));
    }

    private List<String> toList(String[] value) {
        return Arrays.asList(value);
    }

    protected abstract boolean splitValue(Container container, String value);

    protected static class Container {
        private String[] result;

        void contain(String[] result) {
            this.result = result;
        }
    }
}
