package calculator;

import java.util.Optional;

public class StringType {
    private final String str;
    private final Optional<String> separator;

    public StringType(String str, Optional<String> separator) {
        this.str = str;
        this.separator = separator;
    }

    public Splitor getSplitor() {
        if (this.separator.isPresent()) {
            return new CustomSeparatorSplit(str, separator.get());
        }
        return new DefaultSeparatorSplit(str);
    }
}
