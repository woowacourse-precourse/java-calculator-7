package calculator.service;

import calculator.util.Constants;

public class Separator {

    private final String regex;

    private Separator(String regex) {
        validateRegex(regex);
        this.regex = regex;
    }

    public static Separator create(String regex) {
        return new Separator(regex);
    }

    private void validateRegex(String regex) {
        if (regex == null || regex.isEmpty()) {
            throw new IllegalArgumentException("구분자를 찾을 수 없어요. 입력하신 커스텀 구분자를 확인해주세요.");
        }
        if (regex.length() != 1) {
            throw new IllegalArgumentException("구분자는 한 글자여야 해요. 다른 구분자를 사용해주세요.");
        }
        if (regex.matches(Constants.POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자는 커스텀 구분자로 사용할 수 없어요. 다른 구분자를 사용해주세요.");
        }
        if (!SeparatorType.isPermitted(regex)) {
            String reason = SeparatorType.getReason(regex);
            throw new IllegalArgumentException(
                    String.format("해당 구분자(%s)는 커스텀 구분자로 사용할 수 없어요. (사유: %s) 다른 구분자를 사용해주세요.", regex, reason));
        }
    }

    public String getRegex() {
        return regex;
    }
}
