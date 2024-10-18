package calculator.extractor;

import java.util.List;

public interface TokenExtractor {
    List<String> extract(String input);
}