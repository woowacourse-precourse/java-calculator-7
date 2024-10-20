package calculator;

import java.util.Optional;

public class DelimiterExtractor {
    private final String extractPrefix;
    private final String extractSuffix;

    public DelimiterExtractor(String extractPrefix, String extractSuffix) {
        this.extractPrefix = extractPrefix;
        this.extractSuffix = extractSuffix;
    }

    public Optional<Character> extract(String input) {
        // 커스텀 구분자로 시작하고, 커스텀 구분자로 끝나는지 확인
        if (input.startsWith(extractPrefix) && input.length() > extractPrefix.length() + extractSuffix.length()) {
            char delimiter = input.charAt(extractPrefix.length());

            if (checkExtractSuffix(input)) {
                return Optional.of(delimiter);
            }
        }
        return Optional.empty();
    }

    private boolean checkExtractSuffix(String input) {
        return input.substring(extractPrefix.length() + 1, extractPrefix.length() + 1 + extractSuffix.length())
            .equals(extractSuffix);
    }

    public int getExtractHeaderLength() {
        return extractPrefix.length() + 1 + extractSuffix.length();
    }
}
