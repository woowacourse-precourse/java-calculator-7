package calculator.model;

// 사용자 입력 검증 및 데이터 가공
public class Validator {
    final String CUSTOM_START = "//";
    final String CUSTOM_END = "\\n";

    private boolean isCustom(String input) {
        return input.startsWith(CUSTOM_START);
    }

    public String getValidInput(String input) {
        if (isCustom(input)) {
            return input.substring(input.indexOf(CUSTOM_END) + 2);
        }
        return input.replace(":", ",");
    }

    public String getDelimiter(String input) {
        if (isCustom(input)) {
            int index = input.indexOf(CUSTOM_END);
            if (index == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            return input.substring(2, index);
        }
        return ",";
    }
}
