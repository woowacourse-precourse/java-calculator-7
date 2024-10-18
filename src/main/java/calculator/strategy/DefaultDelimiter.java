package calculator.strategy;

public class DefaultDelimiter implements Delimiter {

    @Override
    public String[] split(String input) {
        return input.split("[,:]");
    }
}
