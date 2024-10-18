package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    private ArrayList<String> separator = new ArrayList<>(Arrays.asList(",", ":"));
    private String input;
    private int sum = 0;

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return this.input;
    }

    public ArrayList<String> getSeparator() {
        return this.separator;
    }

    public int getSum() {
        return this.sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


}
