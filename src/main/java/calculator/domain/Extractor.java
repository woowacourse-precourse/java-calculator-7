package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    private static final String customSeparatorPattern = "//(.*?)\n";

    private List<Number> numbers;
    private List<Separator> customSeparators;

    public Extractor(String input) {
        this.customSeparators = extractCustomSeparators(input);
    }

    public List<Separator> getCustomSeparators() {
        return customSeparators;
    }

    public List<Separator> extractCustomSeparators(String input) {
        Pattern pattern = Pattern.compile(customSeparatorPattern);
        Matcher matcher = pattern.matcher(input);
        List<Separator> separators = new ArrayList<>();

        while (matcher.find()) {
            String customSection = matcher.group(1);
            separators.add(new Separator(customSection));
        }

        return separators;
    }
}
