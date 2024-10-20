package calculator;

public class Input {
    private static final String DEFAULT = ",|:";

    private final String str;
    private final String splitter;

    public Input(String input) {
        this.splitter = findSplitter(input);
        this.str = getInputString(input);
    }

    private String findSplitter(String input) {
        if (input.startsWith("//")) {
            return findCustomSplitter(input);
        }
        return DEFAULT;
    }

    private String findCustomSplitter(String input) {
        StringBuilder customSplitter = new StringBuilder(",|:");
        while (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            if (endIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력으로 프로그램이 종료됩니다. 커스텀 구분자 종료 \\n가 존재하지 않습니다.");
            }

            String custom = checkMetaCharacters(input.substring(2, endIndex));
            customSplitter.append("|").append(custom);

            input = input.substring(endIndex + 2);
        }

        return customSplitter.toString();
    }

    private String checkMetaCharacters(String splitter) {
        return splitter.replaceAll("([\\^$.?*+()\\[\\]{}|\\\\-])", "\\\\$1");
    }

    private String getInputString(String input) {
        if (splitter.equals(DEFAULT)) {
            return input;
        }
        return getInputWithoutCustomSplitter(input);
    }

    private String getInputWithoutCustomSplitter(String input) {
        while (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            input = input.substring(endIndex + 2);
        }
        return input;
    }

    public String getStr() {
        return str;
    }

    public String getSplitter() {
        return splitter;
    }
}
