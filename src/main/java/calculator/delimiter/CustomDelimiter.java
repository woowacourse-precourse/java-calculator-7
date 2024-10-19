package calculator.delimiter;

import java.util.regex.Pattern;

public class CustomDelimiter extends Delimiter {

    private Pattern pattern = Pattern.compile("/{2}(.*?)\n");

    public CustomDelimiter() {
        super();
    }

    @Override
    public boolean hasCustomDelimiter(String s) {
        return s.contains("//") && s.contains("\n");
    }

    @Override
    protected void addDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

}
