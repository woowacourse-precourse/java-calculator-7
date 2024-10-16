package separator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeparatorParserImpl implements SeparatorParser {
    private Separator separator;

    @Override
    public void setSeparator(Separator separator) {
        this.separator = separator;
    }

    @Override
    public List<String> split(String line) {
        List<String> result = new ArrayList<>();
        Set<String> separators = separator.getAllSeparator();

        for (String separator : separators) {
            if (line.contains(separator)) {
                line = line.replace(separator, "");
            }
        }

        return List.of(line.split(""));
    }
}
