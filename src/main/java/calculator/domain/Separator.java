package calculator.domain;

public class Separator {
    private static final String customStart = "//";
    private static final String customEnd = "\\n";

    private String separator = ",|:";
    private String currentString;

    public Separator() {
        this.currentString = "";
    }

    public Separator(String input) {
        this.currentString = input;
    }

    public String getCurrentString() {
        return currentString;
    }

    public String getSeparator() {
        return separator;
    }

    public String[] cut() {
        if (currentString.startsWith(customStart) && currentString.contains(customEnd)) {
            separator = customSeparator();
        }
        return currentString.split(separator);
    }
    
    //커스텀 구분자가 존재할경우 실행됨
    private String customSeparator() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");

        for (int i = 2; i < currentString.length(); i++) {
            if (currentString.charAt(i) == '\\' && currentString.charAt(i + 1) == 'n') {
                currentString = currentString.substring(i + 2);
                break;
            }

            sb.append(currentString.charAt(i));
        }

        return separator + sb.toString();
    }
}