package calculator;

public class DelimiterFinder {

    private static String PREFIX_FORMAT = "//";
    private static String SUFFIX_FORMAT = "\n";

    public static String findDelimiter(String input) {
        int customPrefixIndex = input.indexOf(PREFIX_FORMAT);
        String delimiter = ",:";

        if (customPrefixIndex == 0) {
            input = input.replace("\\n", SUFFIX_FORMAT);
            int customSuffixIndex = input.indexOf(SUFFIX_FORMAT);
            checkDelimiterFormat(customSuffixIndex, customPrefixIndex, input);
            delimiter = input.substring(2, customSuffixIndex);
        }
        return delimiter;
    }

    private static void checkDelimiterFormat(int customSuffixIndex, int customPrefixIndex,
        String input) {
        if (customSuffixIndex == -1 || customPrefixIndex + 2 == customSuffixIndex
            || input.indexOf("///") == 0) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 포맷");
        }
    }

    public static int findDelimiterEndIndex(String input) {
        input = input.replace("\\n", SUFFIX_FORMAT);
        if (input.indexOf(PREFIX_FORMAT) == -1) {
            return 0;
        }
        int customSuffixIndex = input.indexOf(SUFFIX_FORMAT);
        return customSuffixIndex + 2;
    }
}
