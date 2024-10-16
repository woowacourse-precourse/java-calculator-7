package calculator.controller;

public class StringSplitter {
    public String[] splitter(String input) {
        String delimiter = "[,:]";

        if (input.startsWith("//")) {
            int endDelimiter = input.indexOf("\n");
            delimiter = input.substring(2, endDelimiter);
            input = input.substring(endDelimiter + 1);
        }

        return input.split(delimiter);
    }
}
