package calculator.Model;

import java.util.ArrayList;

public class Calculate{
    StringManagement sm = new StringManagement();

    public Double plusNum(String input){
        double addNum = 0;
        input = sm.customDelimiter(input);
        ArrayList<Double> num = sm.strToDouble(input);
        for (Double aDouble : num) {
            addNum += aDouble;
        }
        return addNum;
    }
}