package inspector;

public abstract class ContentInspector {
    private String targetContent;
    private String delimiterGroup;

    public abstract String getDelimiterGroup();

    public abstract String getContent();

    protected void inspecting() {
        for (int i = 0; i < targetContent.length(); i++) {
            if (!charcterCheck(targetContent.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean charcterCheck(char inputCharacter) {
        if (Character.isDigit(inputCharacter)) {
            return true;
        }
        return false;
    }
}
