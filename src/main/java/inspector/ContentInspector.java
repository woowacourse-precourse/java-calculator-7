package inspector;

public abstract class ContentInspector {
    protected String targetContent;
    protected String delimiterGroup;

    public ContentInspector(String targetContent) {
        this.targetContent = targetContent;
    }

    protected abstract void inspecting();

    public abstract String getDelimiterGroup();
}
