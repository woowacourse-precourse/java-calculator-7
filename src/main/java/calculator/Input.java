package calculator;

public class Input {
    private final String str;
    private final String splitter;

    public Input(String input) {
        validateInput(input);
        this.splitter = findSplitter(input);
        this.str = getInputString(input);
        validateCharacter(str);
    }

    private void validateInput(String input) {
        if (input.startsWith("//")) {
            validateUsingCustomSplitter(input);
        } else {
            validateDefault(input);
        }
    }

    private void validateUsingCustomSplitter(String input) {
        if (input.length() < 5 || !input.startsWith("\\n", 3)) {
            throw new IllegalArgumentException("잘못된 입력으로 프로그램이 종료됩니다. \"//\"와 \"\\n\" 사이에 위치하는 문자만 커스텀 구분사로 사용할 수 있습니다.");
        }
    }

    private void validateDefault(String input) {
        if (!input.isEmpty() && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("잘못된 입력으로 프로그램이 종료됩니다. 입력이 없거나 숫자 또는 //로 시작해야합니다");
        }
    }

    private String findSplitter(String input) {
        if (!input.startsWith("//")) return "[,:]";
        return String.valueOf(input.charAt(2));
    }

    private String getInputString(String input) {
        if (splitter.equals("[,:]")) {
            return input;
        }
        return input.substring(5);
    }

    private void validateCharacter(String str) {
        boolean defaultSplitter = splitter.equals("[,:]");
        char chSplitter = splitter.charAt(0);
        for (char ch : str.toCharArray()) {
            if (!isValidCharacter(ch, defaultSplitter, chSplitter)) {
                throw new IllegalArgumentException("잘못된 입력으로 프로그램이 종료됩니다. 문자열은 비어있거나 숫자, 구분자만 입력받습니다.");
            }
        }
    }

    private boolean isValidCharacter(char ch, boolean defaultSplitter, char customSplitter) {
        if (Character.isDigit(ch)) {
            return true;
        }
        if (defaultSplitter && (ch == ',' || ch == ':')) {
            return true;
        }
        return ch == customSplitter;
    }

    public String getStr() {
        return str;
    }

    public String getSplitter() {
        return splitter;
    }
}
