package calculator.extractor;

import java.util.List;

public interface DelimitedNumberExtractor {
    List<String> extract(String input);
}