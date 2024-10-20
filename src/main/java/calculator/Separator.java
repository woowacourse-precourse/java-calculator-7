package calculator;

public class Separator {
    private String SEPARATOR = ",|:";

    public String[] separate(String input) {
        return separate(input, SEPARATOR);
    }

    public String[] separate(String input, String separator) {
        String regex = separator;

        if (isContainsCustomSeparatorSymbol(input)) {
            int prefixIdx = input.indexOf(Constants.CUSTOM_SEPARATOR_PREFIX);
            int suffixIdx = input.lastIndexOf(Constants.CUSTOM_SEPARATOR_SUFFIX);

            String customSeparator = getCustomSeparator(input, suffixIdx);
            StringBuilder sb = new StringBuilder(input);
            sb.delete(prefixIdx, suffixIdx + 2);
            input = sb.toString();
            regex = regex.concat("|" + customSeparator);
            System.out.println(regex);
        }

        return input.split(regex);
    }

    public boolean isContainsCustomSeparatorSymbol(String input) {
        return input.startsWith(Constants.CUSTOM_SEPARATOR_PREFIX) && input.contains(Constants.CUSTOM_SEPARATOR_SUFFIX);
    }

    public String getCustomSeparator(String input, int suffixIdx) {
        return String.valueOf(input.charAt(suffixIdx - 1));
    }
}
