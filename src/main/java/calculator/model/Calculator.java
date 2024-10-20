package calculator.model;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;

public class Calculator {

    public int calculateSum(ArrayList<Integer> arrayList){
        int sum = 0;
        for (Integer integer : arrayList) {
            sum += integer;
        }
        return sum;
    }
}
