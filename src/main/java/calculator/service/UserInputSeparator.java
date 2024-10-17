package calculator.service;

public class UserInputSeparator {

    private final String separator;

    private UserInputSeparator(final String userInputMessage) {
        this.separator = userInputMessage;
    }

    public String getSeparator() {
        return separator;
    }

    public static UserInputSeparator of(final String message) {
        if (message.startsWith("//")) {
            final int idx = message.lastIndexOf("\\n");
            if (idx == -1) {
                throw new IllegalArgumentException("커스텀 구분자 종료되지 않음");
            }
            return new UserInputSeparator(message.substring(2, idx));
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInputSeparator that = (UserInputSeparator) o;
        return that.separator.equals(this.separator);
    }
}
