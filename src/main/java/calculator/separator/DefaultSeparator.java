package calculator.separator;

public class DefaultSeparator implements Separator {
    @Override
    public String[] splitLine(String line) {
        return line.split(":|,");
    }
}
