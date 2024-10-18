package inspector;

import java.util.regex.Pattern;

public abstract class ContentInspector {

    public abstract String getParsingSeparator();

    public abstract String getConvertedContent();

    protected void inspecting(String content, String parsingSeparator) {
        String separatorRegex = getSeparatorRegex(parsingSeparator);
        if (!Pattern.matches(separatorRegex, content)) {
            throw new IllegalArgumentException("잘못된 구분자 입력");
        }
    }

    private String getSeparatorRegex(String parsingSeparator) {
        return "^(" + parsingSeparator + "|[0-9])*$";
    }
}
