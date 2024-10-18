package inspector;

import java.util.regex.Pattern;

public abstract class ContentInspector {

    public abstract String getParsingDelimiter();

    public abstract String getContent();

    protected void inspecting(String content, String parsingDelimiter) {
        if (!Pattern.matches("^(" + parsingDelimiter + "|[0-9])*$", content)) {
            System.out.println("매칭되지 않음");
            throw new IllegalArgumentException();
        }
    }
}
