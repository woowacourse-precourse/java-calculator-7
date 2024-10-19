package calculator;

public class UserInput {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_PREFIX_SINGLE_SLASH = "/";
    private static final String CUSTOM_END_PREFIX = "\\n";

    private final String userInput;

    public UserInput(String userInput) {
        validate(userInput);
        this.userInput = userInput;
    }

    private void validate(String input) {
        int customSettingIndex = input.indexOf(CUSTOM_END_PREFIX);
        if (customSettingIndex != -1) {
            String prefix = input.substring(0, customSettingIndex);
            if (!prefix.startsWith(CUSTOM_DELIMITER_PREFIX)) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다 커스텀 구분자는 '//'로 시작해야 합니다.");
            }
        }
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX_SINGLE_SLASH) && !input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다 커스텀 구분자는 '//'로 시작해야 합니다.");
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX) && customSettingIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 정의 후 \\n 이 필요합니다.");
        }

        if (customSettingIndex + 1 >= input.length()) {
            throw new IllegalArgumentException("구분자 정의 후 숫자들이 필요합니다.");
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException("공백만 입력할 수 없습니다.");
        }

        if (Character.isWhitespace(input.charAt(0))) {
            throw new IllegalArgumentException("입력값은 공백으로 시작할 수 없습니다.");
        }
    }

    public String extractCustomDelimiter() {
        int endIndex = userInput.indexOf(CUSTOM_END_PREFIX);
        return userInput.substring(2, endIndex);
    }

    public String extractNumbersPart() {
        int endIndex = userInput.indexOf(CUSTOM_END_PREFIX);
        return userInput.substring(endIndex + 2);
    }

    public boolean isCustom() {
        return userInput.startsWith(CUSTOM_DELIMITER_PREFIX);
    }
    
}