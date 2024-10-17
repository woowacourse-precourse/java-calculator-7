package inspector;

public class DefaultInspector extends ContentInspector {
    protected String targetContent;
    protected String delimiterGroup = ",|:";

    public DefaultInspector(String targetContent) {
        super(targetContent);
    }

    @Override
    protected void inspecting() {
        for (int i = 0; i < targetContent.length(); i++) {
            if (!charcterCheck(targetContent.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public String getDelimiterGroup() {
        return delimiterGroup;
    }

    private boolean charcterCheck(char inputCharacter) {
        if (Character.isDigit(inputCharacter)) {
            return true;
        }
        return false;
    }
}
