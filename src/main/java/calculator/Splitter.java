package calculator;

public class Splitter {

    public String[] splitedByDelimiters(final String input, final Delimiters delimiters,
                                        final RegexGenerator regexGenerator) {
        String regex = regexGenerator.getExcludingDelimiterAreaRegex(delimiters);

        return input.split(regex);
    }

}
