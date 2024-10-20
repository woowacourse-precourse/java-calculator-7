package calculator.validator;

public class DuplicatedCharacterValidator {
    public static void validate(String delimiterString) {
        StringBuilder checkedDelimiter = new StringBuilder();
        for (char delimiter : delimiterString.toCharArray()) {
            if (!checkedDelimiter.toString().contains(String.valueOf(delimiter))) {
                checkedDelimiter.append(delimiter);
                continue;
            }
            throw new IllegalArgumentException("중복된 커스텀 구분자가 입력되었습니다.");
        }
    }
}
