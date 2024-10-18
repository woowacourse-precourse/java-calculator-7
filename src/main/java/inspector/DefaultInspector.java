package inspector;

public class DefaultInspector extends ContentInspector {
    private String targetContent;
    private String parsingDelimiter = ",|:";

    public DefaultInspector(String targetContent) {
        this.targetContent = targetContent;
        inspecting(targetContent, parsingDelimiter);
    }

    @Override
    public String getParsingDelimiter() {
        return parsingDelimiter;
    }

    @Override
    public String getContent() {
        return targetContent;
    }
}
