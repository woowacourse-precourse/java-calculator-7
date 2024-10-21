package calculator;

import java.util.ArrayList;

public class Calculator {

    public double result;

    public void Add(ArrayList<Double> addList) {
        double addResult = 0;
        for (double number : addList) {
            addResult += number;
        }
        result = addResult;
    }
}
