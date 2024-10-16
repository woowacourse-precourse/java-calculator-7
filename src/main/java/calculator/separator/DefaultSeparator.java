package calculator.separator;

public class DefaultSeparator implements Separator {
    @Override
    public String[] splitLine(String line) {
        if (line.isEmpty()) {
            return null;
        }
        return line.split(":|,");
    }
}
