package calculator.Model;

import calculator.Model.StringManagement;

import java.util.ArrayList;

public class Calculate{
    StringManagement sm = new StringManagement();

    public Double plusNum(String input){
        double addNum = 0;
        input = sm.customDelimiter(input);
        ArrayList<Double> num = sm.strToDouble(input);
        for(int i=0;i<num.size();i++){
            addNum += num.get(i);
        }
        return addNum;
    }
}