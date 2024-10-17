package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator implements AutoCloseable {

    public static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private String input;
    private double sum;
    private boolean isCustom;
    private char customChar;
    private Parser parser;
    private DelimiterManager delimiterManager;

    public Calculator() {
        parser = new Parser();
        delimiterManager = new DelimiterManager();
    }

    public Calculator sum() {}

    public void printSum() {
        System.out.println("결과값 : " + sum);
    }

    public void displayPrompt() {
        System.out.println(PROMPT_MESSAGE);
    }

    @Override
    public void close() throws Exception {
        Console.close();
    }


    private class Parser {

        private Parser() {}

        private String parseString() {
            // 검증 로직
            return "test";
        }

        private static boolean isValidString(String str) {}
    }

    private class DelimiterManager {

        private static final int MAX_CUSTOM_DELIMITERS = 3;
        private String delimiters;
        private int count;

        private DelimiterManager() {
            String delimiters = ",:";
            count = 2;
//            delimiters = new String[2];
//            delimiters[0] = ",";
//            delimiters[1] = ":";
        }

        public void addDelimiter(String delimiter) {

            if (count >= MAX_CUSTOM_DELIMITERS) {
                throw new IllegalArgumentException("Only one custom delimiter is allowed.");
            }

            if (delimiters.contains(delimiter)) {
                throw new IllegalArgumentException("Custom delimiter cannot be a default delimiter (',' or ':').");
            }

            delimiters += delimiter;
            count++;
        }

        public String getDelimiters() {
            return delimiters;
        }
    }
}
