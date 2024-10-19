package inspector;

import java.util.regex.Pattern;

public abstract class ContentInspector {

    protected void inspecting(String separator, String content) {
        String contentRegex = getContentRegex(separator);
        detectContentForamt(contentRegex, content);
    }

    private void detectContentForamt(String regex, String content) {
        if (!Pattern.matches(regex, content)) {
            throw new IllegalArgumentException("잘못된 구분자 입력");
        }
    }

    private String getContentRegex(String parsingSeparator) {
        return "^(" + parsingSeparator + "|[0-9])*$";
    }

    public abstract String getSeparator();

    public abstract String getConvertedContent();
}
