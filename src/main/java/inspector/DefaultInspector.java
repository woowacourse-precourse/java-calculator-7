package inspector;

public class DefaultInspector extends ContentInspector {
    private String targetContent;
    private String delimiterGroup = ",|:";

    public DefaultInspector(String targetContent) {
        super(targetContent);
    }

    @Override
    public String getDelimiterGroup() {
        return delimiterGroup;
    }
}
