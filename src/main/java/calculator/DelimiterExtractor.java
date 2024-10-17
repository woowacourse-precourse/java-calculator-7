package calculator;

public class DelimiterExtractor {

    private static final String BOUNDARY_PREFIX = "//";
    private static final String BOUNDARY_SUFFIX = "\\n";

    private DelimiterExtractor() {
    }

    public static String extract(String target) {
        validateBoundary(target);

        int prefixLastIndex = target.indexOf(BOUNDARY_PREFIX) + BOUNDARY_PREFIX.length() - 1;
        int suffixStartIndex = target.indexOf(BOUNDARY_SUFFIX);
        validateDelimiterCount(prefixLastIndex, suffixStartIndex);

        return target.substring(prefixLastIndex + 1, suffixStartIndex);
    }

    private static void validateBoundary(String target) {
        validatePrefix(target);
        validateSuffix(target);
    }

    private static void validatePrefix(String target) {
        if (!target.startsWith(BOUNDARY_PREFIX)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 구분자 지정자입니다.");
        }
    }

    private static void validateSuffix(String target) {
        if (!target.contains(BOUNDARY_SUFFIX)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 구분자 지정자입니다.");
        }
    }

    private static void validateDelimiterCount(int prefixLastIndex, int suffixStartIndex) {
        if (suffixStartIndex - prefixLastIndex != 2) {
            throw new IllegalArgumentException("[ERROR] 구분자는 하나의 문자여야 합니다.");
        }
    }
}