package calculator;


public class InputParser {

    private static final String DEFAULT_DELIMITER = ",|:";

    public String[] parse(String input) {
        String delimiter = DEFAULT_DELIMITER;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            System.out.println("delimiter:" + delimiter);
            input = input.substring(delimiterIndex + 1);
            System.out.println("input:" + input);
        }

        return input.split(delimiter);
    }
}
