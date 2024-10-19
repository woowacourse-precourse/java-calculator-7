package calculator;

public class Separator {
    private String SEPARATOR = ",|:";

    public String[] separate(String input) {
        return separate(input, SEPARATOR);
    }

    public String[] separate(String input, String separator) {
        String regex = separator;

        if (input.startsWith(Constants.CUSTOM_SEPARATOR_PREFIX) && input.contains(Constants.CUSTOM_SEPARATOR_SUFFIX)) {
            int prefixIdx = input.indexOf(Constants.CUSTOM_SEPARATOR_PREFIX);
            int suffixIdx = input.lastIndexOf(Constants.CUSTOM_SEPARATOR_SUFFIX);

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
