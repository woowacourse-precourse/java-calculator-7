package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private StringParser(){

    }

    public static List<Integer> intListWithoutSeparator(String input){
        List<Integer> result = new ArrayList<Integer>();
        if(input.isEmpty())
            result.add(0);

        String[] numberStr = input.split("[,:]");
        for(String s : numberStr){
            result.add(Integer.parseInt(s));
        }

        return result;
    }
}
