package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {

    private String input;
    private List<String> delimiterList = new ArrayList<>();
    private String regex;

    private static final String CUSTOM_DELIM_START = "//";
    private static final String CUSTOM_DELIM_END = "\n";

    public InputProcessor(String input) {
        this.input = input;
        delimiterList.add(",");
        delimiterList.add(":");
    }

    public boolean isDefaultCase() {
        return Character.isDigit(input.charAt(0));
    }

    public boolean isCustomCase() {
        return input.startsWith(CUSTOM_DELIM_START);
    }

    public void getCustomDelimiter() {
        while (input.indexOf(CUSTOM_DELIM_START) == 0) {
            String customDelimiter = input.substring((input.indexOf(CUSTOM_DELIM_START) + CUSTOM_DELIM_START.length()),
                    (input.indexOf(CUSTOM_DELIM_END) - CUSTOM_DELIM_END.length() + 1));
            delimiterList.add(customDelimiter);

            input = input.substring(input.indexOf(CUSTOM_DELIM_END) + CUSTOM_DELIM_END.length());
        }
    }

    public boolean isValidInput() {
        if (input.isEmpty()) {
            input = "0";
            return true;
        } else if (isDefaultCase()) {
            if (!input.replaceAll(regex + "|[0-9]", "").isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력입니다. 입력 문자열은 " +
                        "커스텀 구분자 외 다른 문자를 포함할 수 없습니다.");
            }
            return true;
        } else if (isCustomCase()) {
            getCustomDelimiter();
            regex = String.join("|", delimiterList);
            if (delimiterList.contains("")) {
                throw new IllegalArgumentException("잘못된 입력입니다. 빈칸(\"\")은 커스텀 구분자가 될 수 없습니다.");
            } else if (regex.matches(".*[0-9].*")) {
                throw new IllegalArgumentException("잘못된 입력입니다. 커스텀 구분자에는 숫자를 포함할 수 없습니다.");
            } else if (!input.replaceAll(regex + "|[0-9]", "").isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력입니다. 입력 문자열은 " +
                        "커스텀 구분자 외 다른 문자를 포함할 수 없습니다.");
            }

            return true;
        }
        throw new IllegalArgumentException("잘못된 입력입니다. 입력 포맷을 확인해주세요.");
    }

    public String[] splitInput() {
        isValidInput();
        return input.split(regex);
    }

    public void isNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("잘못된 입력입니다. 음수는 지원하지 않습니다.");
        }
    }

}
