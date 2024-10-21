package calculator;

public class SplitManager {
    public String[] splitString(Input input) {
        String str = input.getStr();
        String splitter = input.getSplitter();

        return splitInputBySplitter(str, splitter);
    }

    private String[] splitInputBySplitter(String str, String splitter) {
        String[] split = str.split(splitter);
        if (split.length < 2 && split[0].isEmpty()) return split;
        checkValidString(split);
        return split;
    }

    private void checkValidString(String[] split) {
        for (String str : split) {
            if (!isValidCharacter(str)) {
                throw new IllegalArgumentException("잘못된 입력으로 프로그램이 종료됩니다. 구분자 외의 문자열은 양수만 가능합니다.");
            }
        }
    }

    private boolean isValidCharacter(String ch) {
        if (ch.isEmpty()) {
            return true;
        }
        if (ch.equals("0") || ch.contains(" ")) {
            return false;
        }
        try {
            int num = Integer.parseInt(ch);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
