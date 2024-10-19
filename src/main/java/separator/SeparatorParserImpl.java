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
    public List<String> split(String line) {
        if (line == null || line.isEmpty()) {
            return Collections.emptyList();
        }
        Set<String> separators = separator.getAllSeparator();

        if (separators == null || separators.isEmpty()) {
            return List.of(line);
        }

        List<String> sortedSeparators = new ArrayList<>(separators);
        sortedSeparators.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));

        StringBuilder regexBuilder = new StringBuilder();
        for (String sep : sortedSeparators) {
            if (!regexBuilder.isEmpty()) {
                regexBuilder.append("|");
            }
            regexBuilder.append(Pattern.quote(sep));
        }

        String regex = regexBuilder.toString();
        String[] splitLine = line.split(regex);

        for (String s : splitLine) {
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new NumberFormatException();
            }
        }

        return Arrays.asList(splitLine);
    }
}
