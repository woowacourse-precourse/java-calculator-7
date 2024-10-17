package calculator.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegDelimiter {
    private List<String> delimiters;
    private int customDeliEndIdx;

    public RegDelimiter() {
        this.delimiters = setDelimiters();
        this.customDeliEndIdx = -1;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public int getCustomDeliEndIdx() {
        return customDeliEndIdx;
    }

    private List<String> setDelimiters() {
        return new ArrayList<>(Arrays.asList(",", ":"));
    }

    public boolean includesCustomDelimiter(String value) {
        if (value.length() >= 2) {
            if (value.charAt(0) == '/' && value.charAt(1) == '/') {
                return true;
            }
        }
        return false;
    }

    public void findCustomDelimiter(String value) {
        String customDeli = "";
        int valueLength = value.length();
        int customDeliEndIdx = -1;

        for (int i=2; i<valueLength; i++) {
            if (checkCustomDelimiterEnd(i, value, valueLength)) {
                customDeliEndIdx = i + 1;
                break;
            }
            customDeli += value.substring(i, i+1);
        }

        validateIfCustomDeliEnds(customDeliEndIdx);
        validateCustomDelimiter(customDeli);

        addCustomDelimiter(customDeli);
        updateCustomDeliEndIdx(customDeliEndIdx);
    }

    private boolean checkCustomDelimiterEnd(int idx, String value, int valueLength) {
        if (idx > 2 && idx < valueLength - 1) {
            if (value.charAt(idx) == '\\' && value.charAt(idx + 1) == 'n') {
                return true;
            }
        }
        return false;
    }

    private void validateIfCustomDeliEnds(int customDeliEndIdx) {
        if (customDeliEndIdx == -1) {
            throw new IllegalArgumentException("잘못된 입력값입니다. '\\n'을 입력해 커스텀 구분자 입력을 마쳐주세요.");
        }
    }

    private void validateCustomDelimiter(String customDeli) {
        String[] reservedWords = new String[]{"//", "\\n", "-", ",", ":"};
        String numberRegex = ".*[0-9].*";

        for (String resWord : reservedWords) {
            if (customDeli.contains(resWord)
            || customDeli.matches(numberRegex)) {
                throw new IllegalArgumentException("잘못된 구분자입니다. '//', '\\n', '-', ',', ':' 또는 숫자를 제외한 문자를 입력해주세요.");
            }
        }
    }

    private void addCustomDelimiter(String customDeli) {
        this.delimiters.add(customDeli);
    }

    private void updateCustomDeliEndIdx(int idx) {
        this.customDeliEndIdx = idx;
    }
}
