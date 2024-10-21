package calculator;

public class Delimiter {

    public String [] findDelimiter(String input) {
        String [] result = new String[2];

        String customDelimiter = "";
        String exceptForDelimiter = input;

        if (exceptForDelimiter.startsWith("//")) {
            exceptForDelimiter = exceptForDelimiter.substring(2);

            if (exceptForDelimiter.contains("\\n")) {
                for (int i = 1; i < exceptForDelimiter.length() - 2; i++) {
                    if (exceptForDelimiter.substring(i, i + 2).equals("\\n")) {
                        customDelimiter = exceptForDelimiter.substring(0, i);
                        exceptForDelimiter = exceptForDelimiter.substring(i + 2);
                        break;
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        result[0] = exceptForDelimiter;
        result[1] = customDelimiter;

        return result;
    }

    public String [] devisionString(String[] inputExceptForDelimiterAndCustomDelimiter) {
        String inputExceptForCustomDelimiter = inputExceptForDelimiterAndCustomDelimiter[0];
        String customDelimiter = inputExceptForDelimiterAndCustomDelimiter[1];

        inputExceptForCustomDelimiter = inputExceptForCustomDelimiter.replace(":", ",");
        inputExceptForCustomDelimiter = inputExceptForCustomDelimiter.replace(customDelimiter, ",");

        return inputExceptForCustomDelimiter.split(",");
    }
}
