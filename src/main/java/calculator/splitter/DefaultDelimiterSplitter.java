package calculator.splitter;

public class DefaultDelimiterSplitter extends AbstractDelimiterSplitter {

    private static final String SPLIT_PATTERN = "[,:]";

    public DefaultDelimiterSplitter() {
        this(0);
    }

    public DefaultDelimiterSplitter(int order) {
        super(order);
    }

    @Override
    protected boolean splitValue(Container container, String value) {
        container.contain(value.split(SPLIT_PATTERN));
        return true;
    }
}
