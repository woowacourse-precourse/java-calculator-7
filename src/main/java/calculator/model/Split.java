package calculator.model;

import java.util.ArrayList;

public class Split {
    private String input;
    public Split(String input) {
        this.input = input;
    }
    public String splitString(ArrayList<String> delimeters) {
        for(String delimeter : delimeters) {
            input = input.replace(delimeter, " ");
            System.out.println(input);
        }
        return input;
    }
}
