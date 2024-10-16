package calculator.domain.separator;

import java.util.List;

public class CustomSeparator implements Separator {

    private final String separator;

    public CustomSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public List<String> separate(String value) {
        return null;
    }
}
