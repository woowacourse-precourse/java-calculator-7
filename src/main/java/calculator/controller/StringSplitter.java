package calculator.controller;

public class StringSplitter {
    public static String[] splitter(String input) {
        String delimiter = "[,:]";
        input = input.trim();
        input = input.replace("\\n", "\n").replace(" ", "");

        if (input.startsWith("//")) {
            int endDelimiter = input.indexOf("\n");
            isValidCustom(endDelimiter);
            delimiter = input.substring(2, endDelimiter);
            input = input.substring(endDelimiter + 1);
        } else {
            isValidDefault(input);
        }

        return input.split(delimiter);
    }

    private static void isValidCustom(int index) {
        if (index == -1) {
            throw new IllegalArgumentException("커스텀 구분자 생성 규칙에 맞지 않습니다.");
        }
    }

    private static void isValidDefault(String input) {
        if (!input.matches("[0-9,:\\s]*")) {
            throw new IllegalArgumentException("기본 구분자 규칙에 맞지 않습니다.");
        }
    }
}
