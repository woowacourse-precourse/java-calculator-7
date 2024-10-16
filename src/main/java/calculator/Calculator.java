package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void displayInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String getInput() {
        return Console.readLine();
    }

    public int add(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }
        if (input.isEmpty()) {
            return 0;
        }

        return 0;
    }

    public String preprocess(String input) {
        return input.replaceAll("\\s", "");
    }

    public String extractCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            String delimiter = input.substring(2, newlineIndex);

            if (delimiter.matches(".*\\d.*")) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
            }
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어 있습니다.");
            }
            return delimiter;
        }
        return null;
    }
}
