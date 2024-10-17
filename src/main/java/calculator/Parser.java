package calculator;

/**
 * Parser
 */
public class Parser {

    public int[] parse(String input) {
        String[] segments;
        int[] numbers;

        try {
            if (input.startsWith("//")) {
                char delimiter = input.charAt(2);
                segments = input.split("\\\\n")[1].split(String.valueOf(delimiter));
            } else {
                segments = input.split("[,|:]");
            }

            numbers = new int[segments.length];
            for (int i = 0; i < segments.length; i++) {
                numbers[i] = Integer.parseInt(segments[i]);
                if (numbers[i] < 0)
                    throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return numbers;
    }
}
