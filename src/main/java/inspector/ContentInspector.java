package inspector;

import static exceptHandler.ExceptHandler.detectContentForamt;

public abstract class ContentInspector {

    protected void inspecting(String separator, String content) {
        String contentRegex = getContentRegex(separator);
        detectContentForamt(contentRegex, content);
    }

    private String getContentRegex(String parsingSeparator) {
        return "^(" + parsingSeparator + "|[0-9])*$";
    }

    public abstract String getSeparator();

    public abstract String getConvertedContent();
}
