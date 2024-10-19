package calculator.domain.identifier;

public class Identifier {

    private final String customKey1 = "//";
    private final String customKey2 = "\\n";

    public String findDelimiter(String string) {
        if (string.startsWith(customKey1)) {
            int customKeyEndIndex = string.indexOf(customKey2);
            if (customKeyEndIndex == 3) {
                return string.substring(customKey1.length(), customKeyEndIndex);
            }
        }
        return null;
    }
}
