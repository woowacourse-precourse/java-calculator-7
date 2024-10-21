package calculator.util;

import static calculator.config.SystemConstantMessages.UTILITY_CLASS_MESSAGE;

public class StringSplitter {
    private static final String DEFAULT_SPLITTER = "[,:]";
    private static final String CUSTOM_SPLITTER_SETTER_PREFIX = "//";
    private static final String CUSTOM_SPLITTER_SETTER_SUFFIX = "\\n";

    private StringSplitter() {
        throw new IllegalStateException(UTILITY_CLASS_MESSAGE);
    }

    public static String[] splitUserInput(String userInput) {
        String customSplitter = getCustomSplitter(userInput);
        if (customSplitter != null) {
            int contentStartIndex =
                    userInput.indexOf(CUSTOM_SPLITTER_SETTER_SUFFIX) + CUSTOM_SPLITTER_SETTER_SUFFIX.length();
            String content = userInput.substring(contentStartIndex);
            return content.split(customSplitter);
        }
        return userInput.split(DEFAULT_SPLITTER);

    }

    private static String getCustomSplitter(String userInput) {
        if (userInput.startsWith(CUSTOM_SPLITTER_SETTER_PREFIX) && userInput.contains(CUSTOM_SPLITTER_SETTER_SUFFIX)) {
            int customSpliterIndex =
                    userInput.indexOf(CUSTOM_SPLITTER_SETTER_PREFIX) + CUSTOM_SPLITTER_SETTER_PREFIX.length();
            int suffixIndex = userInput.indexOf(CUSTOM_SPLITTER_SETTER_SUFFIX);
            return userInput.substring(customSpliterIndex, suffixIndex);
        } else {
            return null;
        }
    }
}
