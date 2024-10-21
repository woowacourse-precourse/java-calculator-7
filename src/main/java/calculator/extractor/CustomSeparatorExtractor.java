package calculator.extractor;

import java.util.Optional;

public interface CustomSeparatorExtractor {
    Optional<String> run(String input);
}
