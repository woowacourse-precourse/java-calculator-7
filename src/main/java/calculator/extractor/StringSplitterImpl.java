package calculator.extractor;

public class StringSplitterImpl implements StringSplitter {

    @Override
    public String[] split(String input) {
        if (input == null || input.isEmpty() || input.equals("\"\"")) {
            return new String[]{""};
        }
        if (input.startsWith("//")) {
            return CustomDelimiter(input);
        }
        return DefaultDelimiter(input);
    }

    private String[] DefaultDelimiter(String input) {
        if (input.matches(".*[\\|\\\\\\n\\t\\r\\f].*")) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다. 구분자는 ','와 ':'만 가능합니다.");
        }
        if (input.matches(".*\\s.*")) {
            throw new IllegalArgumentException("구분자에 공백을 포함할 수 없습니다.");
        }
        if (input.matches(".*[^0-9,-:|\\s].*")) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다. 구분자는 ','와 ':'만 가능합니다.");
        }
        String[] result = input.split("[,:]");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == null || result[i].isEmpty()) {
                result[i] = "";
            }
        }
        return result;
    }
    private String[] CustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다. '\\n'이 필요합니다.");
        }

        String customDelimiter = input.substring(2, delimiterEndIndex);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다. 구분자가 비어 있습니다.");
        }
        return input.substring(delimiterEndIndex + 2).split(customDelimiter);
    }
}
