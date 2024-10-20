package calculator.calculate;

import calculator.view.OutputView;

import java.util.ArrayList;

public class Calculate {
    ArrayList<Integer> numlist;
    OutputView outputView = new OutputView();
    private int CalNum(String input){
        ParsingString extractNum = new ParsingString(input);
        numlist = extractNum.ParsingNum();
        return Makesum(numlist);
    }

    private int Makesum(ArrayList<Integer> numlist){
        int sum = 0;
        for(int i = 0; i < numlist.size(); i++){
            sum += numlist.get(i);
        }
        return sum;
    }

    public void CalStringNum(String input){
        outputView.output(CalNum(input));
    }
}
