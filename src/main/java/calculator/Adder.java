package calculator;

import java.util.ArrayList;

public class Adder {
    long output;
    public Adder(AdderScanner adderScanner) {
        ArrayList<Integer> TokenArray=adderScanner.getOutput();
        output=0;
        for(int num:TokenArray) {
            output +=num;
        }

        //System.out.println("result:" +output);

    }

    public long getOutput() {
        return output;
    }
}
