package calculator;

import java.util.ArrayList;

public class Adder {
    long output=0;
    public Adder(AdderScanner adderScanner) {

        ArrayList<Integer> TokenArray=adderScanner.getOutput();

        for(int num:TokenArray) {
            output +=num;
        }

        //System.out.println("result:" +output);

    }

    public long getOutput() {
        return output;
    }
}
