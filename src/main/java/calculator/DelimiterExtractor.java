package calculator;

public class DelimiterExtractor {
    public String extractDelimiterRegex(String input) {
        // 구분자를 정규식으로 치환
        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("[,:]");

        // 커스텀 구분자 유무 확인 후, 정규식 추가
        if (checkCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            regexBuilder.insert(3, customDelimiter);
        }

        String regex = regexBuilder.toString();
        
        return regex;
    }

    private boolean checkCustomDelimiter(String input) {
        return input.startsWith("//")
                && input.contains("\\n")
                && input.indexOf("\\n") - 2 > 0;
    }

    private String extractCustomDelimiter(String input) {
        StringBuilder customDelimiterBuilder = new StringBuilder();
        customDelimiterBuilder.append(input, 2, input.indexOf("\\n"));

        if (customDelimiterBuilder.toString().contains("[")) {
            int index = customDelimiterBuilder.indexOf("[");
            customDelimiterBuilder.insert(index, "\\");
        }

        if (customDelimiterBuilder.toString().contains("]")) {
            int index = customDelimiterBuilder.indexOf("]");
            customDelimiterBuilder.insert(index, "\\");
        }

        return customDelimiterBuilder.toString();
    }
}
