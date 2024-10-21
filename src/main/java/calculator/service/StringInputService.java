package calculator.service;

public class StringInputService {
    private static final String DEFAULT_DELIMITER = ",|:";

    public String[] processInput(String str) {
        String customDelimiter = DEFAULT_DELIMITER;

        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
            customDelimiter = str.substring(2, delimiterIndex);
            str = str.substring(delimiterIndex + 2);
        }
        return str.split(customDelimiter);
    }

    public boolean isEmptyInput(String str) {
        return str.isEmpty();
    }
}
