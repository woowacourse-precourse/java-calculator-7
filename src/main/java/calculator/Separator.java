package calculator;

public class Separator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String START_SEPARATOR = "//";
    private static final String END_SEPARATOR = "\\n";

    public String[] handleDelimiter(String input) {
        String separator = DEFAULT_SEPARATOR;

        if (input.startsWith(START_SEPARATOR)) {
            int endIndex = input.indexOf(END_SEPARATOR);
            if (endIndex == -1) {
                throw new IllegalArgumentException();
            }
            separator += "|" + input.substring(2, endIndex);

            input = input.substring(endIndex + 2);
        }

        return input.split(separator);
    }
}
