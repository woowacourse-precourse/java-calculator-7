package calculator.separator;

public class DefaultSeparator implements Separator {

    private String line;

    public DefaultSeparator(String line) {
        this.line = line;
    }

    @Override
    public String[] splitLine() {
        if (line.isEmpty()) {
            return null;
        }
        return line.split(":|,");
    }
}
