package calculator;

public class Calculator {

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
        System.out.println("결과값  :  " + sum);
    }

    public void displayPrompt() {
        System.out.println(PROMPT_MESSAGE);
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
        private String[] delimiters;
        private int count;

        private DelimiterManager() {
            delimiters = new String[2];
            delimiters[0] = ",";
            delimiters[1] = ":";
            count = 2;
        }

        public void addDelimiter(String delimiter) {

            if (delimiter.equals(",") || delimiter.equals(":")) {
                throw new IllegalArgumentException("Custom delimiter cannot be a default delimiter (',' or ':').");
            }

            if (count >= MAX_CUSTOM_DELIMITERS) {
                throw new IllegalArgumentException("Only one custom delimiter is allowed.");
            }

            String[] newDelimiters = new String[count + 1];
            System.arraycopy(delimiters, 0, newDelimiters, 0, count);
            delimiters = newDelimiters;
            delimiters[count++] = delimiter;
        }

        public String[] getDelimiters() {
            return delimiters;
        }
    }
}
