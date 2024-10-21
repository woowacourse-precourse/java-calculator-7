package calculator;

import java.util.HashSet;
import java.util.Set;

public class DelimiterExtractor {
    private static Set<String> delimiters = Set.of(",", ";");

    public DelimiterExtractor() {}

    public Set<String> extract(String s) {
        if (s.length() >= 5 && s.substring(0,5).matches("//.\\\\n")) {

            Set<String> delimitersWithCustom = new HashSet<>(delimiters);
            delimitersWithCustom.add(String.valueOf(s.charAt(2)));
            return delimitersWithCustom;
        }
        return delimiters;
    }
}
