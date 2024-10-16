package calculator.delimiter;

public class DelimiterResolverImpl implements DelimiterResolver {
    @Override
    public String delimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다. '\\n'이 필요합니다.");
            }

            String customDelimiter = input.substring(2, delimiterEndIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다. 구분자가 비어 있습니다.");
            }
            return customDelimiter;
        }
        return ",|:";
    }
}



