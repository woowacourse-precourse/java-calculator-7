package detector;

public class CustomSeparatorDetectorImpl implements CustomSeparatorDetector {
    private static final String START_TEXT = "//";
    private static final String END_TEXT = "\\n";

    @Override
    public String detectSeparator(String text) {
        int s = text.indexOf(START_TEXT);
        int e = text.lastIndexOf(END_TEXT);
        if (s < e && s != -1) {
            return text.substring(s + START_TEXT.length(), e);
        }
        return "";
    }
}
