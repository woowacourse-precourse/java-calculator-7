package calculator.logic;

import java.util.Arrays;

public class Sum {



    public static int doSummation(String[] str){

        int sum = 0;

        for(int i=0; i<str.length ; i++) {
            sum += Integer.parseInt(str[i]);
        }

        return sum;
    }

}
