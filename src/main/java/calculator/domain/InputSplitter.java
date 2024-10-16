package calculator.domain;

public class InputSplitter {
    public String[] splitByDelimeter(String input) {
        return input.split("[,:]");
    }
}
