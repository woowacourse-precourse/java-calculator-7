package calculator;

public class Separator {
    private String SEPARATOR = ",|:";
    private final String CUSTOM_SEPARATOR_PREFIX = "//";
    private final String CUSTOM_SEPARATOR_SUFFIX = "\\n";

    public String[] separate(String input) {
        return separate(input, SEPARATOR);
    }

    public String[] separate(String input, String separator) {
        String regex = separator;

        if (input.startsWith(CUSTOM_SEPARATOR_PREFIX) && input.contains(CUSTOM_SEPARATOR_SUFFIX)) {
            int prefixIdx = input.indexOf(CUSTOM_SEPARATOR_PREFIX);
            int suffixIdx = input.lastIndexOf(CUSTOM_SEPARATOR_SUFFIX);

            String customSeparator = String.valueOf(input.charAt(suffixIdx - 1));
            StringBuilder sb = new StringBuilder(input);
            sb.delete(prefixIdx, suffixIdx + 2);
            input = sb.toString();
            regex = regex.concat("|" + customSeparator);
            System.out.println(regex);
        }

        return input.split(regex);
    }
}
