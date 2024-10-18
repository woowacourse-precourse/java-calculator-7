package inspector;

public class DefaultInspector extends ContentInspector {
    private String originalContent;
    private String parsingSeparator = ",|:";

    public DefaultInspector(String originalContent) {
        this.originalContent = originalContent;
        inspecting(originalContent, parsingSeparator);
    }

    @Override
    public String getParsingSeparator() {
        return parsingSeparator;
    }

    @Override
    public String getConvertedContent() {
        return originalContent;
    }
}
