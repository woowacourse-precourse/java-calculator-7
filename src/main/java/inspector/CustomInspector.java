package inspector;

public class CustomInspector extends ContentInspector {
    protected String targetContent;
    protected String parsingDelimiter = ",|:";

    public CustomInspector(String targetContent) {
        this.targetContent = targetContent;
        findCustomDelimiter();
    }

    @Override
    public String getParsingDelimiter() {
        return parsingDelimiter;
    }

    @Override
    public String getContent() {
        return targetContent;
    }

    private void findCustomDelimiter() {
        if (!targetContent.substring(0, 2).equals("//") || !targetContent.substring(3, 5).equals("\\n")) {
            throw new IllegalArgumentException();
        }
        parsingDelimiter = parsingDelimiter.concat("|" + targetContent.charAt(2));
        targetContent = changeContent(targetContent);
        inspecting(targetContent, parsingDelimiter);
    }

    private String changeContent(String targetContent) {
        return targetContent.substring(5);
    }
}
