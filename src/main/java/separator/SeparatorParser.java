package separator;

import java.util.List;

public interface SeparatorParser {
    void setSeparator(Separator separator);
    List<String> split(String s);
}
