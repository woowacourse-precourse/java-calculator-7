package inspector;

public class CustomInspector extends ContentInspector {
    protected String targetContent;
    protected String delimiterGroup = ",|:";

    public CustomInspector(String targetContent) {
        this.targetContent = targetContent;
        findCustomDelimiter();
    }

    @Override
    public String getDelimiterGroup() {
        return delimiterGroup;
    }

    @Override
    public String getContent() {
        return targetContent;
    }

    private void findCustomDelimiter() {
        if (!targetContent.substring(0, 2).equals("//") || !targetContent.substring(3, 5).equals("\\n")) {
            throw new IllegalArgumentException();
        }
        delimiterGroup = delimiterGroup.concat("|" + targetContent.substring(2, 3));
        changeContent();
    }

    private void changeContent() {
        targetContent = targetContent.substring(5);
    }
}
