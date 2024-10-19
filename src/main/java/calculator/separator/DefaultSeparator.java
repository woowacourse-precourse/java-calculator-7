package calculator.separator;

public class DefaultSeparator implements Separator {

    private final String line;

    public DefaultSeparator(String line) {
        this.line = line;
    }

    @Override
    public String[] splitLine() {
        String[] result = line.split(":|,");
        if (line.isEmpty() || result.length == 0) {
            return null;
        }
        return result;
    }

}
