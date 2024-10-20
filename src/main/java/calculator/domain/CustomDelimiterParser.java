package calculator.domain;

import java.util.Optional;

public interface CustomDelimiterParser {
    Optional<Delimiter> getCustomDelimiter();
    String getRemainingInput();
}
