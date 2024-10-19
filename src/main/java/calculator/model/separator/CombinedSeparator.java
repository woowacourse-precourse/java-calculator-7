package calculator.model.separator;

public class CombinedSeparator implements Separator {
    private final String combinedSeparator;

    public CombinedSeparator(String combinedSeparator) {
        this.combinedSeparator = combinedSeparator;
    }

    @Override
    public String getSeparator() {
        return combinedSeparator;
    }
}
