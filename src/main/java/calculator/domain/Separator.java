package calculator.domain;

public class Separator {
    String[] elements;

    public Separator() {
        this.elements = cut("");
    }

    public Separator(String input) {
        this.elements = cut(input);
    }

    public String[] getElements() {
        return elements;
    }

    private String[] cut(String input) {
        return input.split("[,|:]");
    }
}
