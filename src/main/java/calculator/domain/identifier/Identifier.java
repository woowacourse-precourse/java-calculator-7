package calculator.domain.identifier;

public class Identifier {

    private final String customKey1 = "//";
    private final String customKey2 = "\\n";
    private String costomSting;

    public String findDelimiter(String string) {
        if (string.startsWith(customKey1)) {
            int customKeyEndIndex = string.indexOf(customKey2);
            if (customKeyEndIndex == 3) {
                costomSting = string.substring(customKey1.length(), customKeyEndIndex);
                validateDelimiter(costomSting);
                return costomSting;
            }
        }
        return null;
    }

    public void validateDelimiter(String delimiter) {
        String regexMetaChars = ".*+?^${}()|[]\\";
        for (char c : delimiter.toCharArray()) {
            if (regexMetaChars.indexOf(c) != -1) {
                throw new IllegalArgumentException("정규식 메타 문자는 커스텀 구분자로 사용할 수 없습니다: " + delimiter);
            }
        }
    }
}
