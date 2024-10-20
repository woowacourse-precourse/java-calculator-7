package calculator.domain;

public class Calculator {

    private String[] separators;
    private int[] number;
    private int result;

    public Calculator() {
        this.separators = new String[]{":", ","};
        this.result = 0;
    }

    public String[] getSeparators() {
        return separators;
    }

}
