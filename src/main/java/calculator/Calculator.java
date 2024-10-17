package calculator;

public class Calculator {

    private String input;
    private double sum;
    private boolean isCustom;
    private char customChar;
    private Parser parser;
    private DelimeterManager delimeterManager;

    public Calculator() {}

    public Calculator sum() {}

    public void printSum() {
        System.out.println("결과값  :  " + sum);
    }


    private class Parser {

        private Parser() {}

        private String parseString() {
            // 검증 로직
            return "test";
        }

        private static boolean isValidString(String str) {}
    }

    private class DelimeterManager {

        private static final int MAX_CUSTOM_DELIMITERS = 3;
        private String[] delimiters;
        private int count;

        private DelimeterManager() {
            delimiters = new String[2];
            delimiters[0] = ",";
            delimiters[1] = ":";
            count = 2;
        }

        public void addDelimeter(String delimeter) {}

        public String[] getDelimiters() {}
    }
}
