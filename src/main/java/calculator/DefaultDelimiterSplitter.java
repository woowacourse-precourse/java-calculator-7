package calculator;

public class DefaultDelimiterSplitter extends AbstractDelimiterSplitter {

    private static final String SPLIT_PATTERN = "[,:]";

    @Override
    protected boolean splitValue(Container container, String value) {
        container.contain(value.split(SPLIT_PATTERN));
        return true;
    }
}
