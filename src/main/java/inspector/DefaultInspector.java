package inspector;

public class DefaultInspector extends ContentInspector {
    private String originalContent;
    private String separator = ",|:";

    public DefaultInspector(String originalContent) {
        this.originalContent = originalContent;
        inspecting(separator, originalContent);
    }

    @Override
    public String getSeparator() {
        return separator;
    }

    @Override
    public String getConvertedContent() {
        return originalContent;
    }
}
