package model;

import java.util.ArrayList;

public class CalculatorModel {
    private ArrayList<Character> delimiterList;

    public CalculatorModel() {
        delimiterList = new ArrayList<>();
        delimiterList.add(',');
        delimiterList.add(':');
    }

}
