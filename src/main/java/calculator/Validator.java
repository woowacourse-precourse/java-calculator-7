package calculator;

public class Validator {
    public void validate(String input) {
        if (input.contains("-")) {
            throw new IllegalArgumentException("ㅁㅊ음? 음수를 넣는다고?");
        }

        if (input.startsWith(Constants.CUSTOM_SEPARATOR_PREFIX) && !input.contains(Constants.CUSTOM_SEPARATOR_SUFFIX)) {
            throw new IllegalArgumentException("커스텀 구분자 지정 컨벤션이 올바르지 않아요");
        }

        if (!input.startsWith(Constants.CUSTOM_SEPARATOR_PREFIX) && input.contains(Constants.CUSTOM_SEPARATOR_SUFFIX)) {
            throw new IllegalArgumentException("커스텀 구분자 지정 컨벤션이 올바르지 않아요");
        }
    }
}