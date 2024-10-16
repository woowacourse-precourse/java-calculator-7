package calculator.controller;

public class StringSplitter {
    public static String[] splitter(String input) {
        String delimiter = "[,:]";
        input = input.trim();
        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            int endDelimiter = input.indexOf("\n");
            delimiter = input.substring(2, endDelimiter);
            input = input.substring(endDelimiter + 1);
        }

        return input.split(delimiter);
    }
}
