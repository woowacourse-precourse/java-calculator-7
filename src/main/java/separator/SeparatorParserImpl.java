package separator;

import java.util.*;
import java.util.regex.Pattern;

public class SeparatorParserImpl implements SeparatorParser {
    private Separator separator;

    @Override
    public void setSeparator(Separator separator) {
        this.separator = separator;
    }

    @Override
    public List<String> split(String line) throws NumberFormatException {
        if (line == null || line.isEmpty()) {
            return Collections.emptyList();
        }
        if (separator == null) {
            return List.of(line);
        }
        Set<String> separators = separator.getAllSeparator();

        if (separators == null || separators.isEmpty()) {
            return List.of(line);
        }

        List<String> sortedSeparators = new ArrayList<>(separators);
        sortedSeparators.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));

        String regex = buildRegex(sortedSeparators);
        String[] splitLine = line.split(regex);

        checkFormat(splitLine);

        return Arrays.asList(splitLine);
    }

    private String buildRegex(List<String> separators) {
        StringBuilder regexBuilder = new StringBuilder();
        for (String sep : separators) {
            if (!regexBuilder.isEmpty()) {
                regexBuilder.append("|");
            }
            regexBuilder.append(Pattern.quote(sep));
        }
        return regexBuilder.toString();
    }

    private void checkFormat(String[] splitLine) throws NumberFormatException {
        for (String s : splitLine) {
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new NumberFormatException();
            }
        }
    }
}
