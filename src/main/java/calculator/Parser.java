package calculator;

/**
 * Parser
 */
public class Parser {

    public int[] parse(String input) {
        String[] segments;

        if (input.startsWith("//")) {
            char delimiter = input.charAt(2);
            segments = input.split("\n")[1].split(String.valueOf(delimiter));
        } else {
            segments = input.split("[,|:]");
        }

        int[] numbers = new int[segments.length];
        for (int i = 0; i < segments.length; i++) {
            numbers[i] = Integer.parseInt(segments[i]);
        }
        return numbers;
    }
}
