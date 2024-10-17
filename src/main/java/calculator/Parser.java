package calculator;

/**
 * Parser
 */
public class Parser {

    public int[] parse(String input) {
        String[] segments;
        int[] numbers;
        System.out.println(input);

        try {
            if (input.startsWith("//")) {
                char delimiter = input.charAt(2);
                segments = input.split("\n")[1].split(String.valueOf(delimiter));
            } else {
                segments = input.split("[,|:]");
            }

            numbers = new int[segments.length];
            for (int i = 0; i < segments.length; i++) {
                System.out.println("    " + segments[i]);
                numbers[i] = Integer.parseInt(segments[i]);
                System.out.println("    -> " + numbers[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return numbers;
    }
}
