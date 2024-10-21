package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SeparatorParser {
    private final List<String> separator = new ArrayList<>();
    private String removedString = "";

    private void addBasicSeparator() {
        separator.add(",");
        separator.add(":");
    }

    private void parseCustomSeparator(String inputString) {
        Stack<String> buffer = new Stack<>();
        boolean flag = false;
        int idx = 0;

        for (int i = 0; i <= inputString.length() - 1; i++) {
            if (!flag && (inputString.charAt(i) == '/' && inputString.charAt(i + 1) == '/')) {
                buffer.push(inputString.substring(i, i + 2));
                separator.add("");
                flag = true;
                i += 1;
            } else if (inputString.charAt(i) == '\\' && inputString.charAt(i + 1) == 'n') {
                if (buffer.isEmpty() || !flag) {
                    throw new IllegalArgumentException("커스텀 구분자의 짝이 맞지 않습니다.");
                }
                buffer.pop();
                idx++;
                flag = false;
                i += 1;
            } else {
                if (flag) {
                    separator.set(idx, separator.get(idx) + inputString.charAt(i));
                } else {
                    removedString += inputString.charAt(i);
                }
            }
        }

        if (!buffer.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자의 짝이 맞지 않습니다.");
        }
    }

    public List<String> getSeparator() {
        return separator;
    }

    public String getRemovedString() {
        return removedString;
    }
}
