package inspector;

public class DefaultInspector extends ContentInspector {
    private String targetContent;
    private String delimiterGroup = ",|:";

    public DefaultInspector(String targetContent) {
        this.targetContent = targetContent;
    }

    @Override
    public String getDelimiterGroup() {
        return delimiterGroup;
    }

    @Override
    public String getContent() {
        return targetContent;
    }
}
